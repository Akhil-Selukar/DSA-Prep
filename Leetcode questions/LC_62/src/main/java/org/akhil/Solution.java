package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - normal recursion
//    public int uniquePaths(int m, int n) {
//        return pathFinder(m-1, n-1);
//    }
//
//    private int pathFinder(int i, int j) {
//        if(i == 0 && j == 0){
//            return 1;
//        }
//        if(i < 0 || j < 0){
//            return 0;
//        }
//        return pathFinder(i-1, j) + pathFinder(i, j-1);
//    }

    // Solution 2 - Memoization
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for(int[] arr:dp){
//            Arrays.fill(arr, -1);
//        }
//        return pathFinder(m-1, n-1, dp);
//    }
//
//    private int pathFinder(int i, int j, int[][] dp) {
//        if(i == 0 && j == 0){
//            return 1;
//        }
//        if(i < 0 || j < 0){
//            return 0;
//        }
//
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//
//        return dp[i][j] = pathFinder(i-1, j, dp) + pathFinder(i, j-1, dp);
//    }

    // Solution 3 - Tabulation
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return pathFinder(m, n, dp);
    }

    private int pathFinder(int i, int j, int[][] dp) {
        for(int row=0; row<i; row++){
            for(int col=0; col<j; col++){
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                if (row > 0)
                    up = dp[row - 1][col];
                if (col > 0)
                    left = dp[row][col - 1];

                dp[row][col] = up + left;
            }
        }

        return dp[i-1][j-1];
    }
}
