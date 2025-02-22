package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion (TLE)  (O(2^N)/O(N)) 2^N because that many choices we might have to evaluate in worst case, and O(N) space because at most the depth of recursive tree will be N hence stack space of N.
//    public int longestPalindromeSubseq(String s) {
//        return helper(s, 0, s.length()-1);
//    }
//
//    private int helper(String s, int start, int end){
//        // base cases
//        if(start == end){
//            return 1;
//        }
//        if(start > end){
//            return 0;
//        }
//
//        // recursion calls
//        if(s.charAt(start) == s.charAt(end)){
//            return helper(s, start+1, end-1) + 2;   // +2 because start and end are part of palindrome hence they will contribute 2 to the overall length.
//        } else {
//            return Math.max(helper(s, start+1, end), helper(s, start, end-1));  // explore booth the possibilities and return the one which gives larger length.
//        }
//    }


    // Solution 2 - memoization (TLE)   (O(N^2)/O(N^2))
//    public int longestPalindromeSubseq(String s) {
//        int[][] dp = new int[s.length()+1][s.length()+1];
//        for(int[] row:dp){
//            Arrays.fill(row, -1);
//        }
//
//        return helper(s, 0, s.length()-1, dp);
//    }
//
//    private int helper(String s, int start, int end, int[][] dp){
//        // base cases
//        if(start == end){
//            return dp[start][end] = 1;
//        }
//        if(start > end){
//            return dp[start][end] = 0;
//        }
//
//        if(dp[start][end] != -1){
//            return dp[start][end];
//        }
//        // recursion calls
//        if(s.charAt(start) == s.charAt(end)){
//            return dp[start][end] = helper(s, start+1, end-1, dp) + 2;   // +2 because start and end are part of palindrome hence they will contribute 2 to the overall length.
//        } else {
//            return dp[start][end] = Math.max(helper(s, start+1, end, dp), helper(s, start, end-1, dp));  // explore booth the possibilities and return the one which gives larger length.
//        }
//    }

    // Solution 3 - Tabulation (O(N^2)/O(N^2))
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i =0; i<s.length(); i++){
            dp[i][i] = 1;
        }

        for(int i=s.length()-1; i>=0; i--){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
