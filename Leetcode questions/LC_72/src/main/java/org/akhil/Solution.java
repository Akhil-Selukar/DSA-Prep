package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Normal recursion
//    public int minDistance(String word1, String word2) {
//        return helper(word1, word2, word1.length()-1, word2.length()-1);
//    }
//
//    private int helper(String word1, String word2, int i, int j) {
//        if(i<0){
//            return j+1;
//        } if(j<0){
//            return i+1;
//        }
//
//        if(word1.charAt(i) == word2.charAt(j)){
//            return helper(word1, word2, i-1, j-1);
//        }
//
//        int insertion = 1 + helper(word1, word2, i, j-1);
//        int deletion = 1 + helper(word1,word2, i-1, j);
//        int replace = 1 + helper(word1, word2, i-1, j-1);
//
//        return Math.min(insertion, Math.min(deletion, replace));
//    }

    // Solution 2 - Memoization
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        return helper(word1, word2, word1.length()-1, word2.length()-1, dp);
    }

    private int helper(String word1, String word2, int i, int j, int[][] dp) {
        if(i<0){
            return j+1;
        } if(j<0){
            return i+1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = helper(word1, word2, i-1, j-1, dp);
        }

        int insertion = 1 + helper(word1, word2, i, j-1, dp);
        int deletion = 1 + helper(word1,word2, i-1, j, dp);
        int replace = 1 + helper(word1, word2, i-1, j-1, dp);

        return dp[i][j] = Math.min(insertion, Math.min(deletion, replace));
    }
}
