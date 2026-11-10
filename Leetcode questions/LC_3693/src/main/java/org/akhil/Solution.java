package org.akhil;

import java.util.Arrays;

public class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(0, n, costs, dp);
    }

    private int solve(int i, int n, int[] costs, int[] dp) {
        if(i == n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;

        // option 1
        int nextStep = i+1;
        // if this jump is possible the take it and explore further
        if(nextStep <= n) {
            minCost = (costs[nextStep-1] + ((nextStep - i) * (nextStep - i))) + solve(nextStep, n, costs, dp);
        }

        // option 2
        nextStep = i+2;
        if(nextStep <= n){
            minCost = Math.min(minCost, costs[nextStep-1] + ((nextStep - i)*(nextStep-i)) + solve(nextStep, n, costs, dp));
        }

        // Option 3
        nextStep = i+3;
        if(nextStep <= n){
            minCost = Math.min(minCost, costs[nextStep-1] + ((nextStep - i)*(nextStep-i)) + solve(nextStep, n, costs, dp));
        }

        return dp[i] = minCost;
    }
}
