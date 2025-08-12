package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // O(M*N)/O(M*N) where N is given N and M is size of nums list (which can be N if x is 1) so in case of x = 1 complexity will be O(N^2)/O(N^2)
    final int MOD = (int)(1e9+7);
    public int numberOfWays(int n, int x) {
        List<Integer> nums = new ArrayList<>();

        int i = 1;
        while(Math.pow(i, x) <= n){
            nums.add((int)Math.pow(i, x));
            i++;
        }

        int[][] dp = new int[n+1][nums.size()+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        return helper(nums, n, 0, dp);
    }

    private int helper(List<Integer> nums, int n, int index, int[][] dp) {
        if(n == 0){
            return 1;
        }

        if(index >= nums.size() || n < 0){
            return 0;
        }

        if(dp[n][index] != -1){
            return dp[n][index];
        }

        // take
        long take = helper(nums, n-nums.get(index), index+1, dp);
        // not take
        long notTake = helper(nums, n, index+1, dp);

        return dp[n][index] = (int)(take + notTake)%MOD;
    }
}
