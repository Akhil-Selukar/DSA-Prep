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
//    public int maxProfit(int[] prices) {
//        int[][][] dp = new int[prices.length+1][2][3];    // total 3 changing parameters (prices, holding can have value 0/1 hence 2 possible values and cap is max 2 hence 3 possible values (0/1/2)
//
//        /*
//        * As the default value for all integer arrays is 0 and we are initializing the base conditions below as well with 0.
//        * Hence we can skip the base conditions here. But it is written for understanding.
//        * */
////        // for base case (cap <= 0); (when cap is 0 then no matter what index and holding is we will have 0 as answer
////        for(int index = 0; index < prices.length; index++){
////            for(int holdings = 0; holdings<=1; holdings++){
////                dp[index][holdings][0] = 0;
////            }
////        }
////
////        // for base case (index == prices.length); (when index is n then no matter what cap and holding is we will have 0 as answer
////        for(int cap = 1; cap <= 2; cap++){
////            for(int holdings = 0; holdings<=1; holdings++){
////                dp[prices.length][holdings][cap] = 0;
////            }
////        }
//
//        for(int index = prices.length -1; index>=0; index--){   // bottoms up for index (for index prices.length we have already initialized the table in base case hence start with prices.length-1
//            for(int holdings = 0; holdings<=1; holdings++){     // initial holding will be 0 hence from 0 to 1
//                for(int cap = 1; cap<=2; cap++){                // here for every cap 0 we have already initialized the table hence cap will start from 1
//                    if(holdings == 0){
//                        // buy
//                        dp[index][holdings][cap] = Math.max(-prices[index] + dp[index + 1][1][cap], dp[index + 1][0][cap]);
//                    } else {
//                        // sell
//                        dp[index][holdings][cap] = Math.max(prices[index] + dp[index + 1][0][cap - 1], dp[index + 1][1][cap]);
//                    }
//                }
//            }
//        }
//        return dp[0][0][2];
//    }

    // Solution 4 - Best to start with in interview (will give TLE)
    // post this solution implement next (solution 5) as optimization
    // O(N^2)/O(1)
//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        int maxProfit = 0;
//        for(int i=1; i<n; i++){       // i till n because it says AT MOST 2 trades i.e. only 1 trade is also allowed
//            int firstTrade = getMaxProfit(prices, 0, i);
//            int secondTrade = 0;
//            if(i+1<n){       // to prevent out of bounds for second trade (in case we are just making 1 trade and selling at last or last but 1 day.
//                secondTrade = getMaxProfit(prices, i+1, n-1);
//            }
//
//            maxProfit = Math.max(maxProfit, firstTrade + secondTrade);
//        }
//
//        return maxProfit;
//    }
//
//    private int getMaxProfit(int[] prices, int start, int end){
//        int max = 0;
//        int minVal = prices[start];
//
//        for(int i=start+1; i<=end; i++){
//            max = Math.max(max, prices[i]-minVal);
//            minVal = Math.min(minVal, prices[i]);
//        }
//
//        return max;
//    }


    // Approach 5 - Divide and conquer
    /**
     * Here as it is given that we are not allowed to engage in multiple transactions at the same time, hence there will not be any overlap between transactions/
     * Which means for both the transactions there will be a breaking point (i.e. a point which separate first transaction and second transaction)
     * So we can try to divide the given prices array at each index and identify the most profitable trade on each side and whatever will be the max profit value that will be the answer.
     * This will involve breaking the array in two part at each index and finding the max profit on each side (for which we will have to traverse entire part of array on both the sides).
     * Which means (leftHalf + rightHalf = full array) traversal for each breakpoint which is nothing but N times full array traversal so O(N^2) time complexity.
     *
     * But we can reduce this by traversing the array only 2 times one from left to right to calculate Max profitable trade in left side and another from right to let to find second max profitable trade in right side.
     * Then we can simply iterate from 0th index to nth index and check max from both leftMax and rightMax array to maximize the profit.
     */

    // O(N)/O(N)

    public int maxProfit(int[] prices) {
        int n = prices.length;

        // traverse from left to right for first transaction (i.e. we will encounter buy operation first and then sell hence we have to look for min values)
        int[] leftMax = new int[n];
        leftMax[0] = 0;         // day one we will not have anything to sell hence max profit will be 0
        int min = prices[0];

        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], prices[i]-min);
            min = Math.min(min, prices[i]);
        }

        // traverse from right to left for second transaction (here we will encounter sell transaction first hence we will have to track the max price to maximize the profit)
        int[] rightMax = new int[n];
        rightMax[n-1] = 0;
        int max = prices[n-1];

        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }


        // iterate over all days and check for max profit
        int maxProfit = 0;

        for(int i=0; i<n; i++){
            int currProfit = leftMax[i] + rightMax[i];
            maxProfit = Math.max(maxProfit, currProfit);
        }

        return maxProfit;
    }
}

