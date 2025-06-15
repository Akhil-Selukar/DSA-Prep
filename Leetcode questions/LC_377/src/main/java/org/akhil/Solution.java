package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion (TLE)
//    public int combinationSum4(int[] nums, int target) {
//        return helper(nums, 0, 0, target);
//    }
//
//    private int helper(int[] nums, int sum, int pointer, int target){
//        if(sum == target){
//            return 1;
//        }
//
//        if(sum > target || pointer >= nums.length){
//            return 0;
//        }
//
//        int answer = 0;
//
//        answer = answer + helper(nums, sum+nums[pointer], 0, target);
//        answer = answer + helper(nums, sum, pointer+1, target);
//
//        return answer;
//    }


    // Solution 2 - Memoization  (Accepted)
    // O(M*N)/O(M*N) where M is nums.length and N is target.
//    public int combinationSum4(int[] nums, int target) {
//        int[][] dp = new int[target][nums.length+1];
//        for(int[] row:dp){
//            Arrays.fill(row, -1);
//        }
//
//        return helper(nums, 0, 0, target, dp);
//    }
//
//    private int helper(int[] nums, int sum, int pointer, int target, int[][] dp){
//        if(sum == target){
//            return 1;
//        }
//
//        if(sum > target || pointer >= nums.length){
//            return 0;
//        }
//
//        if(dp[sum][pointer] != -1){
//            return dp[sum][pointer];
//        }
//        int answer = 0;
//
//        answer = answer + helper(nums, sum+nums[pointer], 0, target, dp);
//        answer = answer + helper(nums, sum, pointer+1, target, dp);
//
//        return dp[sum][pointer] = answer;
//    }


    // Solution 3 - Here further space complexity can be optimized as we are allowed to reuse same element from array unlimited times.
    // Hence we can basically remove pointer from dp
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, -1);


        return helper(nums, 0, 0, target, dp);
    }

    private int helper(int[] nums, int sum, int pointer, int target, int[] dp){
        if(sum == target){
            return 1;
        }

        if(sum > target || pointer >= nums.length){
            return 0;
        }

        if(dp[sum] != -1){
            return dp[sum];
        }
        int answer = 0;

        answer = answer + helper(nums, sum+nums[pointer], 0, target, dp);
        answer = answer + helper(nums, sum, pointer+1, target, dp);

        return dp[sum] = answer;
    }
}
