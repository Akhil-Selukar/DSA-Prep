package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - without DP normal Recursion (TLE)
    // There are two type of transactions we can perform, normal transaction (buy -> sell) and short selling (sell -> buy)
    // Now if we think of day 1 that means we are just starting. So we will have 3 options, either skip the day or buy or sell.
    // In case we bought on previous day (day 1) then on next day we have only 2 options either skip or sell.
    // But in case we sold on day 1 (short selling) then on next day we can either skip or buy, but we can't sell on the day.
    // So overall we can conclude that we have 3 options as below,
    // 1. In case of fresh start -> skip, buy and sell all 3 allowed
    // 2. In case of normal transaction (i.e. we have already bought the stock) -> skip and sell is allowed
    // 3. In case of short selling (i.e. we have already sold the stock) -> skip and buy is allowed.
    // so we need to keep track fo type of transaction we are trying to perform. (0-> fresh start, 1-> normal transaction, 2-> short selling)
    // Important point to keep in mind is a transaction is said to be completed if we perform both buy and sell operation (either in normal or short selling scenario)

//    public long maximumProfit(int[] prices, int k) {
//        return helper(prices, k, 0, 0);     // initially transaction will be of fresh start
//    }
//
//    private long helper(int[] prices, int k, int index, int type){
//        if(index >= prices.length){
//            if(type == 0){         // to ensure that we are not in middle of any unfinished transaction we can have less than k transaction but we must not have any outstanding transaction.
//                return 0;
//            }
//            // Here if we return Long.MIN_VALUE; then code will fail because in case of type 2 operation '-prices[index] - Long.MIN_VALUE;'
//            // will go out of range hence either return Integer.MIN_VALUE or -(int)(1e9);
//            return Integer.MIN_VALUE;   // otherwise it will be an invalid case (all k transactions are not utilized)
//        }
//
//        // skip transaction
//        long skip = helper(prices, k, index+1, type);        // in case of skip we have not started any transaction hence transaction type will not change
//
//        // perform transaction
//        long take = 0;
//
//        // we can perform transaction only if we have some transaction left
//        if(k > 0){
//            if(type == 0){
//                // take = Math.max((normal trade) buy hence -prices[index], (short sell) sell hence +prices[index])
//                take = Math.max(-prices[index] + helper(prices, k, index+1, 1), prices[index] + helper(prices, k, index+1, 2));
//            } else if(type == 1){
//                // here we have completed the normal transaction i.e. bought and sold as well hence k-1 and now next we will move in 0 state
//                // also we are selling hence we will receive prices[index] so it is +ve
//                take = prices[index] + helper(prices, k-1, index+1, 0);
//            } else {
//                // here we will complete the short selling transaction i.e. sold and then bought here so k-1;
//                // Also we have completed the transaction hence next state will be type 0
//                // as we are buying here so prices[index] is -ve;
//                take = -prices[index] + helper(prices, k-1, index+1, 0);
//            }
//        }
//
//        return Math.max(take, skip);
//    }

    // ---------------------
    // Solution 2 - With memoization (This also gives TLE)
    // O(N*K*3)/O(N*K*3)
//    public long maximumProfit(int[] prices, int k) {
//        int[][][] dp = new int[prices.length][k+1][3];        // [index, no of transaction, type]
//
//        for(int[][] mat:dp){
//            for(int[] row:mat){
//                Arrays.fill(row, -1);
//            }
//        }
//
//        return helper(prices, k, 0, 0, dp);     // initially transaction will be of fresh start
//    }
//
//    private long helper(int[] prices, int k, int index, int type, int[][][] dp){
//        if(index >= prices.length){
//            if(type == 0){         // to ensure that we are not in middle of any unfinished transaction we can have less than k transaction but we must not have any outstanding transaction.
//                return 0;
//            }
//            // Here if we return Long.MIN_VALUE; then code will fail because in case of type 2 operation '-prices[index] - Long.MIN_VALUE;'
//            // will go out of range hence either return Integer.MIN_VALUE or -(int)(1e9);
//            return Integer.MIN_VALUE;   // otherwise it will be an invalid case (all k transactions are not utilized)
//        }
//
//        if(dp[index][k][type] != -1){
//            return dp[index][k][type];
//        }
//
//        // skip transaction
//        long skip = helper(prices, k, index+1, type, dp);        // in case of skip we have not started any transaction hence transaction type will not change
//
//        // perform transaction
//        long take = 0;
//
//        // we can perform transaction only if we have some transaction left
//        if(k > 0){
//            if(type == 0){
//                // take = Math.max((normal trade) buy hence -prices[index], (short sell) sell hence +prices[index])
//                take = Math.max(-prices[index] + helper(prices, k, index+1, 1, dp), prices[index] + helper(prices, k, index+1, 2, dp));
//            } else if(type == 1){
//                // here we have completed the normal transaction i.e. bought and sold as well hence k-1 and now next we will move in 0 state
//                // also we are selling hence we will receive prices[index] so it is +ve
//                take = prices[index] + helper(prices, k-1, index+1, 0, dp);
//            } else {
//                // here we will complete the short selling transaction i.e. sold and then bought here so k-1;
//                // Also we have completed the transaction hence next state will be type 0
//                // as we are buying here so prices[index] is -ve;
//                take = -prices[index] + helper(prices, k-1, index+1, 0, dp);
//            }
//        }
//
//        return Math.max(take, skip);
//    }

    // ---------------------------
    // Solution 3 - Bottoms up solution
    // O(N*K*3)/O(N*K*3)
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n+1][k+1][3];

        // Base case
        for (int i=0; i<=k; i++) {
            dp[n][i][0] = 0;
            dp[n][i][1] = Integer.MIN_VALUE;
            dp[n][i][2] = Integer.MIN_VALUE;
        }

        // Fill table bottom-up
        for (int i = n - 1; i >= 0; i--) {
            for (int kVal = 0; kVal <= k; kVal++) {

                // type 0
                dp[i][kVal][0] = dp[i+1][kVal][0]; // skip
                if (kVal > 0) {
                    dp[i][kVal][0] = Math.max(dp[i][kVal][0], Math.max(-prices[i] + dp[i+1][kVal][1], prices[i] + dp[i+1][kVal][2]));
                }

                // type 1
                dp[i][kVal][1] = dp[i + 1][kVal][1]; // skip
                if (kVal> 0) {
                    dp[i][kVal][1] = Math.max(dp[i][kVal][1], prices[i] + dp[i+1][kVal-1][0]);
                }

                // type 2
                dp[i][kVal][2] = dp[i+1][kVal][2]; // skip
                if (kVal > 0) {
                    dp[i][kVal][2] = Math.max(dp[i][kVal][2], -prices[i] + dp[i+1][kVal-1][0]);
                }
            }
        }

        // Start from day 0, K transactions, no open position
        return dp[0][k][0];
    }
}
