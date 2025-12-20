package org.akhil;

public class Solution {

    // O(N*L)/O(1) where N is number of strings in strs and L is length of string
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int strLen = strs[0].length();
        int result = 0;

        for(int i=0; i<strLen; i++){
            for(int j=1; j<n; j++){
                if(strs[j].charAt(i) < strs[j-1].charAt(i)){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
