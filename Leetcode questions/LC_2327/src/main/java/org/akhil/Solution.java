package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Using memoization
    // O(n * (forget - delay))/O(n)

//    final int MOD = (int)(1e9)+7;
//    int n, delay, forget;
//    int[] dp;
//    public int peopleAwareOfSecret(int n, int delay, int forget) {
//        this.n = n;
//        this.delay = delay;
//        this.forget = forget;
//
//        dp = new int[n+1];
//        Arrays.fill(dp, -1);
//
//        int total = 0;
//
//        // on nth day the people who did remember the secret those only can share further. Hence we need to consider only those people
//        // at nth day all people starting from 'n-forget+1' will only remember the secret.
//        for (int day = n - forget + 1; day <= n; day++) {
//            if (day > 0) {
//                total = (total + helper(day)) % MOD;
//            }
//        }
//
//        return total;
//    }
//
//    private int helper(int day) {
//        if (day == 1){
//            return 1;
//        }
//        if (day <= 0){
//            return 0;
//        }
//
//        if (dp[day] != -1){
//            return dp[day];
//        }
//
//        long result = 0;
//        // people who can share today are those who learned in [day - forget + 1, day - delay]
//        for (int prev = day-forget+1; prev <= day-delay; prev++) {
//            if (prev > 0) {
//                result = (result + helper(prev)) % MOD;
//            }
//        }
//
//        return dp[day] = (int) result;
//    }

    // Solution 2 - Using bottoms up approach (more intuitive approach)
    // O(n * (forget - delay))/O(n)

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = (int)1e9 + 7;
        int[] dp = new int[n + 1]; // dp[day] = number of new people who learn the secret on that day

        // at first day 1 person will learn the secret
        dp[1] = 1;

        for (int day = 2; day <= n; day++) {
            long count = 0;
            // on current day only those people can contribute who either have not forgotten the secret or learned the secret before delay days.
            // people who have not forgotten the secret will be from 'day-forget+1'
            // people who just finish their delay will be at day-delay (only till this day people can contribute in current day)
            for(int prev = day-forget+1; prev <= day-delay; prev++) {
                // if the previous day is -ve that means it was an invalid day
                if (prev > 0) {
                    count = (count + dp[prev]) % MOD;
                }
            }
            dp[day] = (int)count;
        }

        // now we know the number of new people learn the secret on each day.
        // at nth day only those people will still be knowing the secret who have not yet forget the secret.
        // i.e. only those people who learned the secret on or after 'n-forget+1' day
        // so count all those people and that will be the answer.
        int result = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day > 0) {
                result = (result + dp[day]) % MOD;
            }
        }

        return result;
    }
}
