package org.akhil;

public class Solution {
    // O(N*L)/O(N) where N is length of strs and L is length of string in strs
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int n = strs.length;
        int strLen = strs[0].length();
        boolean[] alreadySorted = new boolean[n];

        for(int i=0; i<strLen; i++){
            boolean deleted = false;
            for(int j=1; j<n; j++){
                if(!alreadySorted[j-1]  && strs[j].charAt(i) < strs[j-1].charAt(i)){
                    count++;
                    deleted = true;
                    break;
                }
            }
            if(deleted){
                continue;
            }

            // update alreadySorted status
            for (int k=0; k<n-1; k++) {
                alreadySorted[k] = alreadySorted[k] || (strs[k].charAt(i) < strs[k+1].charAt(i));
            }
        }
        return count;
    }
}
