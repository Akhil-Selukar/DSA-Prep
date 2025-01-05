package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - normal recursion

//    public int change(int amount, int[] coins) {
//        return coinChangeHelper(amount, coins, coins.length-1);
//    }
//
//    private int coinChangeHelper(int amount, int[] coins, int i) {
//        if(amount == 0){
//            return 1;
//        }
//        if(i==0){
//            if(amount % coins[i] == 0){
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        int notTake = coinChangeHelper(amount, coins, i-1);
//        int take = 0;
//        if(amount >= coins[i]){
//            take = coinChangeHelper(amount-coins[i], coins, i);
//        }
//
//        return take+notTake;
//    }

    // Solution 2 - Memoization

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return coinChangeHelper(amount, coins, coins.length-1, dp);
    }

    private int coinChangeHelper(int amount, int[] coins, int i, int[][] dp) {
        if(amount == 0){
            return 1;
        }
        if(i==0){
            if(amount % coins[i] == 0){
                return 1;
            } else {
                return 0;
            }
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int notTake = coinChangeHelper(amount, coins, i-1, dp);
        int take = 0;
        if(amount >= coins[i]){
            take = coinChangeHelper(amount-coins[i], coins, i, dp);
        }

        return dp[i][amount] = take+notTake;
    }
}
