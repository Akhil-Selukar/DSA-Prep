package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Normal recursion
//    public int maxProfit(int[] prices) {
//        return helper(prices, 0, 0, 2);
//    }
//
//    private int helper(int[] prices, int index, int holdings, int cap) {
//
//        if(index == prices.length || cap <= 0){
//            return 0;
//        }
//
//        int profit = 0;
//        if(holdings == 0){
//            // buy
//            profit = Math.max(-prices[index] + helper(prices, index+1, 1, cap), helper(prices, index+1, 0, cap));
//        } else {
//            // sell
//            profit = Math.max(prices[index] + helper(prices, index+1, 0, cap-1), helper(prices, index+1, 1, cap));
//        }
//
//        return profit;
//    }

    // Solution 2 - Memoization
//    public int maxProfit(int[] prices) {
//        int[][][] dp = new int[prices.length][2][3];    // total 3 changing parameters (prices, holding can have value 0/1 hence 2 possible values and cap is max 2 hence 3 possible values (0/1/2)
//        for(int[][] outer:dp){
//            for(int[] row:outer){
//                Arrays.fill(row, -1);
//            }
//        }
//
//        return helper(prices, 0, 0, 2, dp);
//    }
//
//    private int helper(int[] prices, int index, int holdings, int cap, int[][][] dp) {
//        if(index == prices.length || cap <= 0){
//            return 0;
//        }
//
//        if(dp[index][holdings][cap] != -1){
//            return dp[index][holdings][cap];
//        }
//
//        int profit = 0;
//        if(holdings == 0){
//            // buy
//            profit = Math.max(-prices[index] + helper(prices, index+1, 1, cap, dp), helper(prices, index+1, 0, cap, dp));
//        } else {
//            // sell
//            profit = Math.max(prices[index] + helper(prices, index+1, 0, cap-1, dp), helper(prices, index+1, 1, cap, dp));
//        }
//
//        return dp[index][holdings][cap] = profit;
//    }

    // Solution 3 - Tabulation
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];    // total 3 changing parameters (prices, holding can have value 0/1 hence 2 possible values and cap is max 2 hence 3 possible values (0/1/2)

        /*
        * As the default value for all integer arrays is 0 and we are initializing the base conditions below as well with 0.
        * Hence we can skip the base conditions here. But it is written for understanding.
        * */
//        // for base case (cap <= 0); (when cap is 0 then no matter what index and holding is we will have 0 as answer
//        for(int index = 0; index < prices.length; index++){
//            for(int holdings = 0; holdings<=1; holdings++){
//                dp[index][holdings][0] = 0;
//            }
//        }
//
//        // for base case (index == prices.length); (when index is n then no matter what cap and holding is we will have 0 as answer
//        for(int cap = 1; cap <= 2; cap++){
//            for(int holdings = 0; holdings<=1; holdings++){
//                dp[prices.length][holdings][cap] = 0;
//            }
//        }

        for(int index = prices.length -1; index>=0; index--){   // bottoms up for index (for index prices.length we have already initialized the table in base case hence start with prices.length-1
            for(int holdings = 0; holdings<=1; holdings++){     // initial holding will be 0 hence from 0 to 1
                for(int cap = 1; cap<=2; cap++){                // here for every cap 0 we have already initialized the table hence cap will start from 1
                    if(holdings == 0){
                        // buy
                        dp[index][holdings][cap] = Math.max(-prices[index] + dp[index + 1][1][cap], dp[index + 1][0][cap]);
                    } else {
                        // sell
                        dp[index][holdings][cap] = Math.max(prices[index] + dp[index + 1][0][cap - 1], dp[index + 1][1][cap]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
}
