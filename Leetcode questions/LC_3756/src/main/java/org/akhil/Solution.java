package org.akhil;

public class Solution {
    final int MOD = (int)(1e9+7);

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] prefixSum = new long[n + 1]; // to store prefix sum of digits up to index i
        long[] concatVal = new long[n + 1]; // to store concatenated numeric value of non-zero digits up to i
        int[]  count  = new int[n + 1];  // to store number of non-zero digits up to index i
        long[] pow  = new long[n + 1]; // to store 10^i % mod

        for (int i = 1; i <= n; i++) {
            int num = s.charAt(i - 1) - '0';

            prefixSum[i] = (prefixSum[i - 1] + num) % MOD;

            if (num == 0) {
                concatVal[i] = concatVal[i - 1];
                count[i]  = count[i - 1];
            } else {
                concatVal[i] = (concatVal[i - 1] * 10 + num) % MOD;
                count[i]  = count[i - 1] + 1;
            }
        }

        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * 10) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];

            // Sum of digits in [left, right]
            long sum = (prefixSum[right + 1] - prefixSum[left] + MOD) % MOD;

            long leftpart = concatVal[left];
            long rightpart = concatVal[right + 1];
            int  diff      = count[right + 1] - count[left];
            long power     = pow[diff];
            long range     = (rightpart - (leftpart * power) % MOD + MOD) % MOD;

            ans[i] = (int) (range * sum % MOD);
        }

        return ans;
    }
}
