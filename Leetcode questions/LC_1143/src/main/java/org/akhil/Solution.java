package org.akhil;

import java.util.Arrays;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return helper(text1, text2, text1.length()-1, text2.length()-1, dp);
    }

    private int helper(String str1, String str2, int p1, int p2, int[][] dp) {
        if(p1 < 0 || p2 < 0){
            return 0;
        }

        if(dp[p1][p2] != -1){
            return dp[p1][p2];
        }

        if(str1.charAt(p1) == str2.charAt(p2)){
            return 1 + helper(str1, str2, p1-1, p2-1, dp);
        }

        int leftRecursion = helper(str1, str2, p1-1, p2, dp);
        int rightRecursion = helper(str1, str2, p1, p2-1, dp);

        return dp[p1][p2] = Math.max(leftRecursion, rightRecursion);
    }
}
