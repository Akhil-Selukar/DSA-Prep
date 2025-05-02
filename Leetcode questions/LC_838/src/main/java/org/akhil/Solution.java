package org.akhil;

public class Solution {
    // Here 1 solution can be iterating entire string multiple times and identifying the movements and then based on some conditions modifying the values
    // but this will be O(N^2) TC which is not allowed as constraints are 10^5

    // O(N)/O(N) solution
    public String pushDominoes(String dominoes) {
        int lastLeftPush = -1;
        int lastRightPush = -1;
        StringBuilder sb = new StringBuilder(dominoes);

        for(int i=0; i<dominoes.length(); i++){
            if(dominoes.charAt(i) == '.'){
                continue;
            }

            if(dominoes.charAt(i) == 'L'){
                if(lastLeftPush == -1 && lastRightPush == -1){
                    leftFall(0, i, sb);
                    lastLeftPush = i;
                }
                if(lastLeftPush > lastRightPush){
                    leftFall(lastLeftPush, i, sb);
                    lastLeftPush = i;
                }
                if(lastRightPush > lastLeftPush){
                    doubleSideFall(lastRightPush, i, sb);
                    lastLeftPush = i;
                }
            }
            if(dominoes.charAt(i) == 'R'){
                if(lastLeftPush == -1 && lastRightPush == -1){
                    lastRightPush = i;
                    continue;
                }
                if(lastLeftPush > lastRightPush){
                    lastRightPush = i;
                    continue;
                }
                if(lastRightPush > lastLeftPush){
                    rightFall(lastRightPush, i, sb);
                    lastRightPush = i;
                }
            }
        }

        // edge case
        if(lastRightPush > lastLeftPush){
            rightFall(lastRightPush, dominoes.length(), sb);
        }

        return sb.toString();
    }

    private void rightFall(int start, int end, StringBuilder sb) {
        for(int i=start; i<end; i++){
            sb.setCharAt(i, 'R');
        }
    }

    private void doubleSideFall(int start, int end, StringBuilder sb) {
        while(start<end){
            sb.setCharAt(start,'R');
            sb.setCharAt(end, 'L');
            start++;
            end--;
        }
    }

    private void leftFall(int start, int end, StringBuilder sb){
        for(int i=start; i<end; i++){
            sb.setCharAt(i, 'L');
        }
    }
}
