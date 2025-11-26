package org.akhil;

public class Solution {

    // Solution 1 - Bruteforce without Memoization

//    int[][] directions = {{0, 1}, {1, 0}};
//    final int MOD = (int)(7 + 1e9);
//    public int numberOfPaths(int[][] grid, int k) {
//        if(grid.length == 0){
//            return 0;
//        }
//
//        return helper(grid, k, 0, 0, 0);
//    }
//
//    private int helper(int[][] grid, int k, int i, int j, int currSum){
//        if(i >= grid.length || j >= grid[0].length){
//            return 0;
//        }
//
//        if(i == grid.length-1 && j == grid[0].length-1){
//            return ((currSum + grid[i][j]) % k) == 0 ? 1 : 0;
//        }
//
//        currSum = currSum + grid[i][j];
//        int result = 0;
//
//        for(int[] direction:directions){
//            int newI = i + direction[0];
//            int newJ = j + direction[1];
//
//            if(newI < grid.length && newJ < grid[0].length){
//                result = (result + helper(grid, k, newI, newJ, currSum))%MOD;
//            }
//        }
//        return result;
//    }

//    // -------------------
//    // Solution 2 - With memoization  (Still TLE)
//    // O(R*C*k)/O(R*C*K) where R is no of rows, C is no of columns.
//    final int MOD = (int)(7 + 1e9);
//    public int numberOfPaths(int[][] grid, int k) {
//        if(grid.length == 0){
//            return 0;
//        }
//
//        Integer[][][] dp = new Integer[grid.length][grid[0].length][k];
//
//        return helper(grid, k, 0, 0, 0, dp);
//    }
//
//    private int helper(int[][] grid, int k, int i, int j, int currRem, Integer[][][] dp){
//        if(i >= grid.length || j >= grid[0].length){
//            return 0;
//        }
//
//        if(dp[i][j][currRem] != -1){
//            return dp[i][j][currRem];
//        }
//        if(i == grid.length-1 && j == grid[0].length-1){
//            return ((currRem + grid[i][j]) % k) == 0 ? 1 : 0;
//        }
//
//        currRem = (currRem + grid[i][j]) % k;           // (a+b+c+d+...)%k = ((((a+b)%k) + c)%k + d)%k) +...... try using pen and paper
//
//        int right = helper(grid, k, i, j+1, currRem, dp);
//        int down = helper(grid, k, i+1, j, currRem, dp);
//
//        return (right + down)%MOD;
//    }


    // -------------
    // Solution 3 - With bottoms up
    // O(R*C*k)/O(R*C*K) where R is no of rows, C is no of columns.
    final int MOD = (int)(7 + 1e9);
    public int numberOfPaths(int[][] grid, int k) {
        if (grid.length == 0) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;

        int[][][] dp = new int[r+1][c+1][k];

        for (int rem = 0; rem < k; rem++) {
            dp[r - 1][c - 1][rem] = ((rem + grid[r - 1][c - 1]) % k == 0) ? 1 : 0;
        }

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                for (int remainder = 0; remainder < k; remainder++) {
                    if (i == r - 1 && j == c - 1) {
                        continue;
                    }

                    int newRem = (remainder + grid[i][j]) % k;

                    long right = dp[i][j + 1][newRem];
                    long down = dp[i + 1][j][newRem];

                    dp[i][j][remainder] = (int) (right + down) % MOD;
                }
            }
        }
        return dp[0][0][0];
    }
}
