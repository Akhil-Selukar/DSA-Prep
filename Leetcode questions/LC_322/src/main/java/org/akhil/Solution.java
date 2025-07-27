package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Recursion
//    public int coinChange(int[] coins, int amount) {
//        int i = coins.length;
//
//        return coinChangeHelper(coins, amount, i-1);
//    }
//
//    private int coinChangeHelper(int[] coins, int target, int i) {
//        if (i == 0) {
//            if (target % coins[i] == 0) {
//                return target / coins[i];
//            }
//            else return (int)1e9;
//        }
//
//        int notTake = coinChangeHelper(coins, target, i-1);
//        int take = (int)1e9;
//        if(target >= coins[i]){
//            take = 1 + coinChangeHelper(coins, target-coins[i], i);
//        }
//        return Math.min(take, notTake);
//    }

    // Solution 2 - Memoization
//    public int coinChange(int[] coins, int amount) {
//        int i = coins.length;
//        int[][] dp = new int[coins.length][amount+1];
//        for(int[] arr: dp){
//            Arrays.fill(arr, (int)1e9);
//        }
//
//        return coinChangeHelper(coins, amount, i-1, dp);
//    }
//
//    private int coinChangeHelper(int[] coins, int target, int i, int[][] dp) {
//        if (i == 0) {
//            if (target % coins[i] == 0) {
//                return target / coins[i];
//            }
//            else return (int)1e9;
//        }
//
//        if(dp[i][target] != (int)1e9){
//            return dp[i][target];
//        }
//
//        int take = (int)1e9;
//        if(target >= coins[i]){
//            take = 1 + coinChangeHelper(coins, target-coins[i], i, dp);
//        }
//        int notTake = coinChangeHelper(coins, target, i-1, dp);
//
//        return dp[i][target] = Math.min(take, notTake);
//    }

    // Solution 3 - Tabulation
//    public int coinChange(int[] coins, int amount) {
//        int[][] dp = new int[coins.length][amount+1];
//
//        // initialize the base condition (i.e. when index will be 0 and target amount can be anything in that case using coin at 0th index are we able to achieve target.)
//        for(int amt = 0; amt<=amount; amt++){
//            if(amt % coins[0] == 0){
//                dp[0][amt] = amt/coins[0];
//            }else {
//                dp[0][amt] = (int)1e9;
//            }
//        }
//
//        for(int i=1; i<coins.length; i++){
//            for(int amt = 0; amt<=amount; amt++){
//                int take = (int)1e9;
//                if(amt >= coins[i]){
//                    take = 1 + dp[i][amt-coins[i]];
//                }
//                int notTake = dp[i-1][amt];
//
//                dp[i][amt] = Math.min(take, notTake);
//            }
//        }
//
//        int res = dp[coins.length-1][amount];
//        return res >= (int)1e9 ? -1 : res;
//    }

    // Solution 4 - Memory optimized
//    public int coinChange(int[] coins, int amount) {
//        int[] previous = new int[amount+1];
//
//        // initialize the base condition (i.e. when index will be 0 and target amount can be anything in that case using coin at 0th index are we able to achieve target.)
//        for(int amt = 0; amt<=amount; amt++){
//            if(amt % coins[0] == 0){
//                previous[amt] = amt/coins[0];
//            }else {
//                previous[amt] = (int)1e9;
//            }
//        }
//
//        int[] current = new int[amount+1];
//        for(int i=1; i<coins.length; i++){
//            for(int amt = 0; amt<=amount; amt++){
//                int take = (int)1e9;
//                if(amt >= coins[i]){
//                    take = 1 + current[amt-coins[i]];
//                }
//                int notTake = previous[amt];
//
//                current[amt] = Math.min(take, notTake);
//            }
//            previous = current;
//        }
//
//        int res = previous[amount];
//        return res >= (int)1e9 ? -1 : res;
//    }


    // Solution 5 - Memory optimized (simple solution)

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp, (int)1e9);      // Initially we assume it is not possible to create the amount even with infinite coins
        dp[0] = 0;          // 0 amount can be created using 0 coins

        for(int amt=1; amt<=amount; amt++){
            for(int coin:coins){
                if(amt-coin >= 0){      // if we can take the coin
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt-coin]);      // minimum of earlier value or 1 + coins required for remaining amount
                }
            }
        }

        return dp[amount] == (int)1e9 ? -1 : dp[amount];
    }
}
