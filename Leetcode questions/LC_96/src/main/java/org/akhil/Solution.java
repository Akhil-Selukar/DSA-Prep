package org.akhil;

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];     // n+1 because we need to consider 0 nodes as well here.
        dp[0] = 1;
        dp[1] = 1;

        for(int node=2; node<=n; node++){
            int unique = 0;
            for(int root = node; root>0; root--){
                unique = unique + (dp[root-1] * dp[node-root]);
            }
            dp[node] = unique;
        }

        return dp[n];
    }
}
