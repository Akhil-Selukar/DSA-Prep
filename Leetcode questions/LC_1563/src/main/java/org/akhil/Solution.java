package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(N^3)/O(N^2)
    int[][] dp = new int[501][501];

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] cumSum = new int[n];
        cumSum[0] = stoneValue[0];
        for(int i = 1; i < n; i++) {
            cumSum[i] = cumSum[i-1] + stoneValue[i];
        }
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, n-1, cumSum);
    }

    public int helper(int left, int right, int[] cumSum) {
        if(left >= right) {
            return 0; // No further division possible
        }
        if(dp[left][right] != -1) {
            return dp[left][right];
        }
        int aliceScore = 0;
        for(int mid = left; mid <= right-1; mid++) {
            int leftSum  = cumSum[mid] - (left-1 >= 0 ? cumSum[left-1] : 0);
            int rightSum = cumSum[right] - cumSum[mid];
            if(leftSum < rightSum) {
                aliceScore = Math.max(aliceScore, leftSum + helper(left, mid, cumSum));
            } else if(leftSum > rightSum) {
                aliceScore = Math.max(aliceScore, rightSum + helper(mid+1, right, cumSum));
            } else {
                aliceScore = Math.max(aliceScore, Math.max(leftSum + helper(left, mid, cumSum), rightSum + helper(mid+1, right, cumSum)));
            }
        }
        return dp[left][right] = aliceScore;
    }
}
