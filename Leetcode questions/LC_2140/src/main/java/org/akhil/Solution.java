package org.akhil;

import java.util.Arrays;

public class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];
        Arrays.fill(dp, -1);
        return helper(questions, 0, dp);
    }

    private long helper(int[][] questions, int index, long[] dp){
        if(index >= questions.length){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        long take = questions[index][0] + helper(questions, index+questions[index][1]+1, dp);
        long skip = helper(questions, index+1, dp);

        return dp[index] = Math.max(take, skip);
    }
}
