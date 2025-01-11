package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion
//    public int maxProfit(int k, int[] prices) {
//        return helper(prices, 0, 0, k);
//    }
//
//    private int helper(int[] prices, int index, int holdings, int k) {
//
//        if(index >=prices.length || k<=0){
//            return 0;
//        }
//
//        int profit = 0;
//        if(holdings == 0){
//            // buy
//            profit = Math.max(-prices[index] + helper(prices, index+1, 1, k), helper(prices, index+1, 0, k));
//        } else {
//            // sell
//            profit = Math.max(prices[index] + helper(prices, index+1, 0, k-1), helper(prices, index+1, 1, k));
//        }
//        return profit;
//    }

    // Solution 2 - Memoization
//    public int maxProfit(int k, int[] prices) {
//        int[][][] dp = new int[prices.length][2][k+1];
//        for(int[][] temp:dp){
//            for(int[] row:temp){
//                Arrays.fill(row, -1);
//            }
//        }
//
//        return helper(prices, 0, 0, k, dp);
//    }
//
//    private int helper(int[] prices, int index, int holdings, int k, int[][][] dp) {
//
//        if(index >=prices.length || k<=0){
//            return 0;
//        }
//
//        if(dp[index][holdings][k] != -1){
//            return dp[index][holdings][k];
//        }
//
//        int profit = 0;
//        if(holdings == 0){
//            // buy
//            profit = Math.max(-prices[index] + helper(prices, index+1, 1, k, dp), helper(prices, index+1, 0, k, dp));
//        } else {
//            // sell
//            profit = Math.max(prices[index] + helper(prices, index+1, 0, k-1, dp), helper(prices, index+1, 1, k, dp));
//        }
//        return profit;
//    }

    // Solution 3 - Tabulation
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1];

//        // Base condition (k<=0), no matter what is the value of other two answer will be 0.
//        for(int index = 0; index<prices.length; index++){
//            for(int holdings = 0; holdings<=1; holdings++){
//                dp[index][holdings][0] = 0;
//            }
//        }
//        // Base condition (index >=prices.length), no matter what is the value of other two answer will be 0.
//        for(int cap = 1; cap<=k; cap++){
//            for(int holdings = 0; holdings<=1; holdings++){
//                dp[prices.length][holdings][cap] = 0;
//            }
//        }

        for(int index = prices.length-1; index>=0; index--){
            for(int holdings=0; holdings<=1; holdings++){
                for(int cap=1; cap<=k; cap++){
                    if(holdings == 0){
                        // buy
                        dp[index][holdings][cap] = Math.max(-prices[index] + dp[index+1][1][cap], dp[index+1][0][cap]);
                    } else {
                        // sell
                        dp[index][holdings][cap] = Math.max(prices[index] + dp[index+1][0][cap-1], dp[index+1][1][cap]);
                    }
                }
            }
        }
        return dp[0][0][k];
    }
}
