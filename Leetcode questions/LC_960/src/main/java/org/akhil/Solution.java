package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(N*L^2)/O(L) where N is number of strings in strs and L is length of string
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        int[] dp = new int[cols+1];
        int maxLongestValid = 1;    // starting from 1 because atleast a single char will form a valid string (same reason as dp[i] = 1)

        // initially all chars are the longest valid string in itself hence dp[i] will be 1
        Arrays.fill(dp, 1);

        // for each column index we need to check the longest valid string we can create.
        // check each string from every index to the left of current (i.e. end) index for validity (i.e. previous char
        // has to be smaller than the current char)
        for(int end=1; end<cols; end++){
            for(int start=0; start<end; start++){
                if(isValid(strs, start, end)){
                    dp[end] = Math.max(dp[end], dp[start]+1);       // check comment in isValid method.
                    maxLongestValid = Math.max(maxLongestValid, dp[end]);
                }
            }
        }

        return cols-maxLongestValid;            // from total length of string if we remove maxValid length we will get no of columns to remove
    }

    private boolean isValid(String[] strs, int start, int end){
        // check for each string
        for(String str:strs){
            if(str.charAt(start) > str.charAt(end)){
                // this pair of char is invalid so we can have at max string to the left of start + endChar, and everything
                // from start till end-1 has to be deleted. So we can say that the valid string length will be whatever max length
                // we can get till start (i.e. dp[start] plus 1 for end char)
                return false;
            }
        }

        // the start index and end index str is vallid for all strings
        return true;
    }
}
