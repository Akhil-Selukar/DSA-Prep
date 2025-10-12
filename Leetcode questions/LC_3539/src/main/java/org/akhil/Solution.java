package org.akhil;

import java.util.Arrays;

public class Solution {
    static final int MOD = (int)(1e9)+7;
    static final long[] FACT = new long[31];
    static final long[] INV_FACT = new long[31];        // because max value of k is 30 so 31.

    // static block to initialize the global variables
    static {
        FACT[0] = 1;
        for (int i = 1; i < 31; i++){
            FACT[i] = FACT[i - 1] * i % MOD;
        }

        INV_FACT[31 - 1] = pow(FACT[31 - 1], MOD - 2);
        for (int i = 31 - 1; i > 0; i--) {
            INV_FACT[i - 1] = INV_FACT[i] * i % MOD;
        }
    }

    static long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n >>= 1, x = x * x % MOD)
            if ((n & 1) == 1) res = res * x % MOD;
        return res;
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        int[][] pows = new int[n][m + 1];

        for (int i = 0; i < n; i++) {
            pows[i][0] = 1;
            for (int j = 1; j <= m; j++)
                pows[i][j] = (int) ((long) pows[i][j - 1] * nums[i] % MOD);
        }

        // initialize DP
        int[][][][] dp = new int[n][m + 1][m / 2 + 1][k + 1];
        for (int[][][] a : dp) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }

        return (int) (dfs(0, m, 0, k, pows, dp) * FACT[m] % MOD);
    }

    private long dfs(int i, int mLeft, int carry, int kLeft, int[][] pows, int[][][][] dp) {
        int ones = Integer.bitCount(carry);

        if (ones + mLeft < kLeft){
            return 0; // if it is not possible to create k with remaining bits return 0
        }

        if (i == pows.length) { // base case
            return (mLeft == 0 && ones == kLeft) ? 1 : 0;
        }

        if (dp[i][mLeft][carry][kLeft] != -1){
            return dp[i][mLeft][carry][kLeft]; // memoization
        }

        long res = 0;
        for (int j = 0; j <= mLeft; j++) {
            int bit = (carry + j) & 1; // current bit
            if (bit <= kLeft) { // If its a useful bit
                long r = dfs(i + 1, mLeft - j, (carry + j) >> 1, kLeft - bit, pows, dp);
                res = (res + r * pows[i][j] % MOD * INV_FACT[j]) % MOD; // add the result
            }
        }
        return dp[i][mLeft][carry][kLeft] = (int) res;
    }
}
