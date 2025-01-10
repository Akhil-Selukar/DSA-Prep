package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Normal recursion
//    public int maxProfit(int[] prices) {
//        return helper(prices, 0, 0);
//    }
//
//    private int helper(int[] prices, int index, int holding) {
//        if(index == prices.length){
//            return 0;
//        }
//
//        int profit = 0;
//        if(holding == 0){
//            // buy
//            profit = Math.max(-prices[index] + helper(prices, index+1, 1), helper(prices, index+1, 0));
//        } else {
//            // sell
//            profit = Math.max(prices[index] + helper(prices, index+1, 0), helper(prices, index+1, 1));
//        }
//        return profit;
//    }

    // Solution 2 - Memoization
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return helper(prices, 0, 0, dp);
    }

    private int helper(int[] prices, int index, int holding, int[][] dp) {
        if(index == prices.length){
            return 0;
        }

        if(dp[index][holding] != -1){
            return dp[index][holding];
        }

        int profit = 0;
        if(holding == 0){
            // buy
            profit = Math.max(-prices[index] + helper(prices, index+1, 1, dp), helper(prices, index+1, 0, dp));
        } else {
            // sell
            profit = Math.max(prices[index] + helper(prices, index+1, 0, dp), helper(prices, index+1, 1, dp));
        }
        return dp[index][holding] = profit;
    }

    // Another solution
    public int maxProfit_anotherWay(int[] prices) {
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                profit = profit + prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
