package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion
//    public int knapSack(int capacity, int val[], int wt[]) {
//
//        return knapSackHelper(val, wt, capacity, wt.length-1);
//    }
//
//    private int knapSackHelper(int[] val, int[] wt, int capacity, int index) {
//
//        if(capacity == 0 || index<0){
//            return 0;
//        }
//        if(index == 0){
//            if(wt[index] <= capacity){
//                return val[index];
//            }
//            return 0;
//        }
//
//        int take = Integer.MIN_VALUE;
//        if(wt[index] <= capacity){
//            take = val[index] + knapSackHelper(val, wt, capacity-wt[index], index-1);
//        }
//        int notTake = knapSackHelper(val, wt, capacity, index-1);
//
//        return Math.max(take, notTake);
//    }

    // Solution 2 - Memoization
    public int knapSack(int capacity, int val[], int wt[]) {
        int[][] dp = new int[wt.length][capacity+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }

        return knapSackHelper(val, wt, capacity, wt.length-1, dp);
    }

    private int knapSackHelper(int[] val, int[] wt, int capacity, int index, int[][] dp) {
        if(capacity == 0 || index<0){
            return 0;
        }
        if(index == 0){
            if(wt[index] <= capacity){
                return val[index];
            }
            return 0;
        }

        if(dp[index][capacity] != -1){
            return dp[index][capacity];
        }

        int take = Integer.MIN_VALUE;

        if(wt[index] <= capacity){
            take = val[index] + knapSackHelper(val, wt, capacity-wt[index], index-1, dp);
        }
        int notTake = knapSackHelper(val, wt, capacity, index-1, dp);

        return dp[index][capacity] = Math.max(take, notTake);
    }
}
