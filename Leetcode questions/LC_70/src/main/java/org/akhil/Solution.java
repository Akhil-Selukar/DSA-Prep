package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution - 1 (Normal recursion) This will work but for large numbers will give TLE on leetcode because of multiple recursive calls.
//    public int climbStairs(int n) {
//        if(n == 0 || n == 1){
//            return 1;
//        }
//        return climbStairs(n-2) + climbStairs(n-1);
//    }

    // Solution - 2 (memoization approach) Here as well we will get TLE even though this is a better solution that 1st one as range of n given in question is till 10^18
//    public int climbStairs(int n) {
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        return stepsCounter(n, dp);
//    }
//
//    private int stepsCounter(int n, int[] dp){
//        if(n == 0 || n == 1){
//            return 1;
//        }
//        if(dp[n] != -1){
//            return dp[n];
//        }
//        return dp[n] = (climbStairs(n-2) + climbStairs(n-1));
//    }


    // Solution - 3 Tabulation

//    public int climbStairs(int n) {
//        if(n == 0 || n == 1){
//            return 1;
//        }
//
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//
//        dp[0] = 1;
//        dp[1] = 1;
//
//        for(int i=2; i<=n; i++){
//            dp[i] = (dp[i-2]+ dp[i-1]);
//        }
//        return dp[n];
//    }


    // Solution - 4 Space optimization
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int secondPrevious = 1;
        int previous = 1;

        for(int i=2; i<=n; i++){
            int current = secondPrevious + previous;
            secondPrevious = previous;
            previous = current;
        }

        return previous;
    }
}
