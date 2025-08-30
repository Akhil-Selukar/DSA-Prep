package org.akhil;

import java.util.Arrays;

public class Solution {
    public int MOD = ((int)1e9+7);
    int[][] directions = {{0,1}, {1,0}};
    public int uniquePaths(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return helper(grid, 0, 0, dp);
    }

    private int helper(int[][] grid, int i, int j, int[][] dp){
        if(i == grid.length-1 && j == grid[0].length-1){
            return 1;
        }

        if(i >= grid.length || j >= grid[0].length){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        long count = 0;
        for(int d=0; d<2; d++){
            int[] direction = directions[d];
            int d1 = direction[0];
            int d2 = direction[1];
            int newI = i + d1;
            int newJ = j + d2;

            if(newI < grid.length && newJ < grid[0].length){
                while(newI < grid.length && newJ < grid[0].length && grid[newI][newJ] == 1){
                    newI = newI + (d1 == 1 ? 0 : 1);
                    newJ = newJ + (d2 == 1 ? 0 : 1);
                    d1 = Math.abs(d1-1);
                    d2 = Math.abs(d2-1);
                }
                count = count + helper(grid, newI, newJ, dp)%MOD;
            }
        }
        return dp[i][j] = (int)(count % MOD);
    }
}
