package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Normal recursion
//    public int maxProfit(int[] prices) {
//        return helper(prices, 0, 0);
//    }
//
//    private int helper(int[] prices, int index, int holdings) {
//
//        if(index >= prices.length){
//            return 0;
//        }
//
//        if(holdings == 0){
//            return Math.max(-prices[index] + helper(prices, index+1, 1), helper(prices, index+1, 0));
//        } else {
//            return Math.max(prices[index]+helper(prices, index+2, 0), helper(prices, index+1, 1));
//        }
//    }

    // Solution 2 - Memoization
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return helper(prices, 0, 0, dp);
    }

    private int helper(int[] prices, int index, int holdings, int[][] dp) {

        if(index >= prices.length){
            return 0;
        }

        if(dp[index][holdings] != -1){
            return dp[index][holdings];
        }

        if(holdings == 0){
            return dp[index][holdings] = Math.max(-prices[index] + helper(prices, index+1, 1, dp), helper(prices, index+1, 0, dp));
        } else {
            return dp[index][holdings] = Math.max(prices[index]+helper(prices, index+2, 0, dp), helper(prices, index+1, 1, dp));
        }
    }
}
