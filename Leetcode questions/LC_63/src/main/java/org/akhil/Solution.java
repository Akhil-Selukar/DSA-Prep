package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int row = obstacleGrid.length;
//        int col = obstacleGrid[0].length;
//
//        return pathsWithObstacle(obstacleGrid, row-1, col-1);
//    }
//
//    private int pathsWithObstacle(int[][] obstacleGrid, int m, int n) {
//        if(m==0 && n==0){
//            return 1;
//        }
//        if(m <0 || n<0 || obstacleGrid[m][n] == 1){
//            return 0;
//        }
//
//        return pathsWithObstacle(obstacleGrid, m-1, n) + pathsWithObstacle(obstacleGrid, m, n-1);
//    }

    // Solution 2 - Memoization

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }

        return pathsWithObstacle(obstacleGrid, row-1, col-1, dp);
    }

    private int pathsWithObstacle(int[][] obstacleGrid, int m, int n, int[][] dp) {
        if(m==0 && n==0 && obstacleGrid[m][m] == 0){
            return 1;
        }
        if(m <0 || n<0 || obstacleGrid[m][n] == 1){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        return dp[m][n] = pathsWithObstacle(obstacleGrid, m-1, n, dp) + pathsWithObstacle(obstacleGrid, m, n-1, dp);
    }
}
