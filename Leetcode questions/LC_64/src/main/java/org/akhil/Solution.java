package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion
//    public int minPathSum(int[][] grid) {
//        int row = grid.length;
//        int col = grid[0].length;
//
//        return minPathSumHelper(row-1, col-1, grid);
//    }
//
//    private int minPathSumHelper(int m, int n, int[][] grid) {
//        if(m == 0 && n == 0){
//            return grid[m][n];
//        }
//        if(m < 0 || n < 0){
//            return (int)1e9;
//        }
//
//        return grid[m][n] + Math.min(minPathSumHelper(m-1, n, grid), minPathSumHelper(m, n-1, grid));
//    }

    // Solution 2 - Memoization
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }

        return minPathSumHelper(row-1, col-1, grid, dp);
    }

    private int minPathSumHelper(int m, int n, int[][] grid, int[][] dp) {
        if(m == 0 && n == 0){
            return grid[m][n];
        }
        if(m < 0 || n < 0){
            return (int)1e9;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        return dp[m][n] = grid[m][n] + Math.min(minPathSumHelper(m-1, n, grid, dp), minPathSumHelper(m, n-1, grid, dp));
    }
}
