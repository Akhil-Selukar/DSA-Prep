package org.akhil;

public class Solution {
    public int maxPathScore(int[][] grid, int k) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][k+1];

        return helper(grid,0, 0, k, dp);
    }

    int helper( int[][] grid, int row, int col, int k, Integer[][][] dp) {
        if(row >= grid.length || col >= grid[0].length || k < 0) {
            return -1;
        }

        int val = grid[row][col];

        if(val > 0 && k <= 0) {       // we need some cost but we don't have any k left
            return -1;
        }

        // reached destination
        if(row == grid.length-1 && col == grid[0].length-1) {
            return val;
        }

        if(dp[row][col][k]!=null) {
            return dp[row][col][k];
        }

        int nextK = k;

        if(val > 0) {
            nextK = k - 1;
        }

        int right = helper(grid, row, col+1, nextK, dp);
        int down = helper(grid,row+1, col, nextK, dp);

        if(right == -1 && down == -1) {   // if no valid path exist
            return dp[row][col][k] = -1;
        }

        return dp[row][col][k] = val + Math.max(right, down);
    }
}
