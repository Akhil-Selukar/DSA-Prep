package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion (TLE)
//    public int getMoneyAmount(int n) {
//        return helper(0, n);
//    }
//
//    private int helper(int start, int end) {
//        if(start >= end){
//            return 0;           // either I won (== case) or range is invalid (> case)
//        }
//
//        int max = Integer.MAX_VALUE;
//        for(int choice=start; choice<=end; choice++){       // here choice is just like middle element in BS but as we can choose any value hence applying loop
//            max = Math.min(max, choice + Math.max(helper(start, choice-1), helper(choice+1, end)));
//                // Min(whatever max we have timme not, if we choose incorrect ans then amount we have to give + other two choices we can make)
//        }
//
//        return max;
//
//    }


    // Solution 2 - with memoization
    // O(N^2)/O(N^2)
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        return helper(0, n, dp);
    }

    private int helper(int start, int end, int[][] dp) {
        if(start >= end){
            return 0;           // either I won (== case) or range is invalid (> case)
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }

        int max = Integer.MAX_VALUE;
        for(int choice=start; choice<=end; choice++){       // here choice is just like middle element in BS but as we can choose any value hence applying loop
            max = Math.min(max, choice + Math.max(helper(start, choice-1, dp), helper(choice+1, end, dp)));
            // Min(whatever max we have timme not, if we choose incorrect ans then amount we have to give + other two choices we can make)
        }

        return dp[start][end] = max;

    }
}
