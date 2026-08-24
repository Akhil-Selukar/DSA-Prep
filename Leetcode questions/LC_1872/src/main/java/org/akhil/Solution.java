package org.akhil;

import java.util.Arrays;

public class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        int[] prefixSum = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        prefixSum[0] = stones[0];
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + stones[i];
        }

        return helper(prefixSum, 1, dp);
    }

    private int helper(int[] prefixSum, int i, int[] dp) {
        if(i == prefixSum.length-1) {   // we reach till end of prefix sum array means by taking turns we have added all stones till we left with final addition (i.e. 1 stone)
            return prefixSum[prefixSum.length-1];
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take = prefixSum[i] - helper(prefixSum, i+1, dp);   // decided to take stones till ith index

        int skip = helper(prefixSum, i+1, dp);   // decided to go to next index to pick stones

        return dp[i] = Math.max(take, skip);
    }
}
