package org.akhil;

public class Solution {

    // O(N)/O(1)    // space complexity is constant because no matter what is the value of N but dp[] array will have length of 1001 fixed.
    public int numTilings(int n) {
        int mod = (int)(7+1e9);
        long[] dp = new long[1001];         // because constraints are 1<= n <=1000

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        if(n<=3){
            return (int)dp[n];
        }

        for(int i=4; i<=n; i++){
            dp[i] = 2*dp[i-1]+dp[i-3];
            dp[i] = (int)(dp[i] % mod);
        }

        return (int)dp[n];
    }
}
