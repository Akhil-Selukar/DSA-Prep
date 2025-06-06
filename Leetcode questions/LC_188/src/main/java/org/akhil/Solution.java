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
//    public int maxProfit(int k, int[] prices) {
//        int[][][] dp = new int[prices.length+1][2][k+1];
//
////        // Base condition (k<=0), no matter what is the value of other two answer will be 0.
////        for(int index = 0; index<prices.length; index++){
////            for(int holdings = 0; holdings<=1; holdings++){
////                dp[index][holdings][0] = 0;
////            }
////        }
////        // Base condition (index >=prices.length), no matter what is the value of other two answer will be 0.
////        for(int cap = 1; cap<=k; cap++){
////            for(int holdings = 0; holdings<=1; holdings++){
////                dp[prices.length][holdings][cap] = 0;
////            }
////        }
//
//        for(int index = prices.length-1; index>=0; index--){
//            for(int holdings=0; holdings<=1; holdings++){
//                for(int cap=1; cap<=k; cap++){
//                    if(holdings == 0){
//                        // buy
//                        dp[index][holdings][cap] = Math.max(-prices[index] + dp[index+1][1][cap], dp[index+1][0][cap]);
//                    } else {
//                        // sell
//                        dp[index][holdings][cap] = Math.max(prices[index] + dp[index+1][0][cap-1], dp[index+1][1][cap]);
//                    }
//                }
//            }
//        }
//        return dp[0][0][k];
//    }


    // Solution 4 - State transition algorithm/method
    /**
     * As we are allowed k transactions and each transaction involves 2 operations (buy and sell) hence total operations we have to perform are 2k.
     * Now to perform 2k operations we have n days available. So there can be 3 cases.
     *
     * case 1 - n <= 1 (i.e. we only have 1 day)
     *          In this case we can't even perform 1 complete transaction hence max profit will be 0.
     *
     * case 2 - 2k >= n (i.e. number of operations are more than number of available days)
     *          in this case even if we do 1 operation (buy/sell) every day still we will not exhaust the transaction limit of k.
     *          Which intern mean we can do transaction on every day, so the max profit will be the addition of all upward moving curves in price graph (if we draw line graph of price against days)
     *
     * case 3 - 2k < n (i.e. number of days available are greater than total operations (buy/sell) we need to perform)
     *          in this case we have to select the best days to transact so that the profit is maximum.
     *          To solve this scenario we can use below state transition method.
     *
     *          State transition ->
     *          Observations
     *          -> We know that we need to perform 2k operations.
     *          -> To make profit we need to sell the stock and to sell the stock we first need to buy it, hence first operation will be buy operation.
     *          -> As it is given that we can not involve in multiple transactions hence we are not allowed to do 2 consecutive buy operations. so 2nd operation has to be sell one.
     *          -> As per above two observations 3rd operation has to be buy, 4th sell and so on. (in general odd number operation will be buy and even numbered operation will be sell operation).
     *
     *          pre-processing ->
     *          Now as we know the number of operations we need to perform (2k) and on which index what will be the operation, so we can define the dp array to store state at each operation.
     *          so the dp array will be of length 2k. Now as the first operation will be of buy, so we wil have to pay money and our profit will go in negative and as we want to maximize the profit
     *          we will initialize 0th index (i.e. 1st operation (all odd index operations)) of DP with lowest value possible in negative profit (i.e. Integer.MIN_VALUE) and at 2nd operation (i.e. all
     *          even numbered operation) as the operation is of sell stock so we will be receiving money hence profit will go in positive and lowest profit in positive direction we can make is 0.
     *          Hence we will initialize all even index in dp array (i.e. state array) with 0.
     *          Now further on each day we will consider that day as possible ith operation and calculate what max profit we can make if that day we are doing ith transaction (i from 0 to 2k-1) every value individually.
     *
     *          Algorithm ->
     *          At 1st state (i.e. index 0) we will be either buying the stock or skipping that day. Hence state[0] will be max(state[0], -prices[0]) (as there is no previous day available hence -prices[0]) this will always be -price[0] because it will be always greater than Integer.MIN_VALUE.
     *          At 2nd state (i.e. index 1) we have to sell the stock so state[1] will be max(state[1], state[0]+prices[1])
     *          At 3rd state (i.e. index 2) we will have to buy again so state[2] will be max(state[2], state[1]-prices[2])
     *
     *          Now apart from index 0 for all other case same will repeat so if the operation is odd numbered operation then it will be like 2nd state and even number operation will be like 3rd state operation.
     *          At the end after iterating through all the prices what we will have at (2k-1)th index (i.e. 2kth state) will be the max possible profit after 2k operations or k transactions.
     */

    // O(N*K)/O(K)
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // case 1
        if(n <= 1){
            return 0;
        }

        // case 2
        if(2*k >= n){
            int maxProfit = 0;
            for(int i=1; i<n; i++){
                if(prices[i] > prices[i-1]){
                    maxProfit = maxProfit + (prices[i] - prices[i-1]);
                }
            }
            return maxProfit;
        }

        // case 3
        int[] states = new int[2*k];

        // initializing dp array (states)
        for(int i=0; i<2*k; i++){
            if(i%2 == 0){
                states[i] = Integer.MIN_VALUE;
            } else {
                states[i] = 0;
            }
        }

        for(int i=0; i<n; i++){             // iterate over price
            for(int j=0; j<2*k; j++){       // for ith price calculate all states
                if(j==0){
                    states[j] = Math.max(states[j], -prices[i]);
                } else if(j%2 == 1){       // sell operation
                    states[j] = Math.max(states[j], states[j-1]+prices[i]);
                } else {       // buy operation (i.e. j%2 == 0)
                    states[j] = Math.max(states[j], states[j-1]-prices[i]);
                }
            }
        }

        return states[(2*k)-1];
    }
}
