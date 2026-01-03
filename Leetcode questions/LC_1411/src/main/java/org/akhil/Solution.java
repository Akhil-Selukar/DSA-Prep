package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Normal recursion (TLE)
//    long MOD = (long)(7+1e9);
//    public int numOfWays(int n) {
//        return 6*countWays(1, n, 0) + 6*countWays(1, n, 1);
//    }
//
//    private int countWays(int row, int n, int type){
//        if(row == n){
//            return 1;
//        }
//
//        long ans = 0;
//        if(type == 0){
//            ans = ((2*countWays(row+1, n, 0)%MOD) + (2*(countWays(row+1, n, 1))%MOD));
//        }
//        if(type == 1){
//            ans = ((2*(countWays(row+1, n, 0)%MOD)) + (3*(countWays(row+1, n, 1))%MOD));
//        }
//        return (int)ans;
//    }

    // ----------------------
    // Solution 2 - Memoization
    // O(N)/O(N) and column is fixed to 2
    long MOD = (long)(7+1e9);
    public int numOfWays(int n) {
        long[][] dp = new long[n][2];
        for(long[] row:dp){
            Arrays.fill(row, -1);
        }
        long result = 6*countWays(1, n, 0, dp) + 6*countWays(1, n, 1, dp);
        return (int)(result%MOD);
    }

    private long countWays(int row, int n, int type, long[][] dp){
        if(row == n){
            return 1;
        }

        if(dp[row][type] != -1){
            return dp[row][type];
        }

        long ans = 0;
        if(type == 0){
            ans = ((2*countWays(row+1, n, 0, dp)%MOD) + (2*(countWays(row+1, n, 1, dp))%MOD));
        }
        if(type == 1){
            ans = ((2*(countWays(row+1, n, 0, dp)%MOD)) + (3*(countWays(row+1, n, 1, dp))%MOD));
        }

        return dp[row][type] = ans;
    }
}
