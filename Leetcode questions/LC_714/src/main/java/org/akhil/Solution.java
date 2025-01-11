package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion
//    public int maxProfit(int[] prices, int fee) {
//        return helper(prices, fee, 0, 0);
//    }
//
//    private int helper(int[] prices, int fee, int index, int holdings) {
//
//        if(index >= prices.length){
//            return 0;
//        }
//
//        if(holdings == 0){
//            return Math.max(-prices[index]+helper(prices, fee, index+1, 1), helper(prices, fee, index+1, 0));
//        } else {
//            return Math.max(prices[index] - fee + helper(prices, fee, index+1, 0), helper(prices, fee, index+1, 1));
//        }
//    }

    // Solution 2 - Memoization
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return helper(prices, fee, 0, 0, dp);
    }

    private int helper(int[] prices, int fee, int index, int holdings, int[][] dp) {

        if(index >= prices.length){
            return 0;
        }

        if(dp[index][holdings] != -1){
            return dp[index][holdings];
        }

        if(holdings == 0){
            return dp[index][holdings] = Math.max(-prices[index]+helper(prices, fee, index+1, 1, dp), helper(prices, fee, index+1, 0, dp));
        } else {
            return dp[index][holdings] = Math.max(prices[index] - fee + helper(prices, fee, index+1, 0, dp), helper(prices, fee, index+1, 1, dp));
        }
    }
}
