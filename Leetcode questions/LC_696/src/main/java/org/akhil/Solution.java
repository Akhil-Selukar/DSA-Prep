package org.akhil;

public class Solution {

    // O(N)/O(1)
    public int countBinarySubstrings(String s) {
        int n = s.length();

        int prevBlockCount = 0;
        int currBlockCount = 1;
        int result = 0;

        for(int i=1; i<n; i++){
            if(s.charAt(i-1) == s.charAt(i)){
                // same block is progressing
                currBlockCount++;
            } else {
                // next block started
                prevBlockCount = currBlockCount;
                currBlockCount = 1;
            }

            if(prevBlockCount >= currBlockCount){
                result++;
            }
        }
        return result;
    }
}
