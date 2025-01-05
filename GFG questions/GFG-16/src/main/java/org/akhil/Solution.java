package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - normal recursion
//    public int knapSack(int val[], int wt[], int capacity) {
//        return helper(val, wt, capacity, val.length-1);
//    }
//
//    private int helper(int[] val, int[] wt, int capacity, int i) {
//        if(i == 0){
//            if(capacity >= wt[i]){
//                return (capacity/wt[i])*val[i];
//            } else {
//                return 0;
//            }
//        }
//
//        int notPick = helper(val, wt, capacity, i-1);
//        int pick = 0;
//        if(capacity >= wt[i]){
//            pick = val[i] + helper(val, wt, capacity-wt[i], i);
//        }
//
//        return Math.max(pick, notPick);
//    }

    // Solution 2 - Memoization
    public int knapSack(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length][capacity+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return helper(val, wt, capacity, val.length-1, dp);
    }

    private int helper(int[] val, int[] wt, int capacity, int i, int[][] dp) {
        if(i == 0){
            if(capacity >= wt[i]){
                return (capacity/wt[i])*val[i];
            } else {
                return 0;
            }
        }

        if(dp[i][capacity] != -1){
            return dp[i][capacity];
        }
        int notPick = helper(val, wt, capacity, i-1, dp);
        int pick = 0;
        if(capacity >= wt[i]){
            pick = val[i] + helper(val, wt, capacity-wt[i], i, dp);
        }

        return dp[i][capacity] = Math.max(pick, notPick);
    }
}
