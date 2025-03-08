package org.akhil;

public class Solution {

    // Solution 1 - Bruteforce approach sliding window/two pointer (O(k*length)/O(k))
//    public int minimumRecolors(String blocks, int k) {
//        int length = blocks.length();
//        int minChanges = Integer.MAX_VALUE;
//        int start = 0;
//        int end = k;
//
//        while(end<=length){
//            String str = blocks.substring(start, end);
//            int changes = getChanges(str);
//            if(changes < minChanges){
//                minChanges = changes;
//            }
//            start++;
//            end++;
//        }
//        return minChanges;
//    }
//
//    private int getChanges(String str) {
//        int changes = 0;
//        for(char ch:str.toCharArray()){
//            if(ch == 'W'){
//                changes++;
//            }
//        }
//        return changes;
//    }


    // Solution 2 - Optimized sliding window (O(N)/O(1))
    public int minimumRecolors(String blocks, int k) {
        int whiteCount = 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<blocks.length(); i++){
            if((i-k)>=0 && blocks.charAt(i-k) == 'W'){
                whiteCount--;
            }
            if(blocks.charAt(i) == 'W'){
                whiteCount++;
            }

            if((i-(k-1))>=0){
                ans = Math.min(ans, whiteCount);
            }
        }

        return ans;
    }
}
