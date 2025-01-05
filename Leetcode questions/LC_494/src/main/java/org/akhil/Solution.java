package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion

//    public int findTargetSumWays(int[] nums, int target) {
//        return helper(nums, target, nums.length-1, 0);
//    }
//
//    private int helper(int[] nums, int target, int i, int sum) {
//        if(i<0){
//            if(sum == target){
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        int subtract = helper(nums, target, i-1, sum-nums[i]);
//        int add = helper(nums,  target, i-1,sum+nums[i]);
//        return add+subtract;
//    }

    // Solution 2 - Memoization

    public int findTargetSumWays(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, (int)-1e9);
        return helper(nums, target, nums.length-1, 0, dp);
    }

    private int helper(int[] nums, int target, int i, int sum, int[] dp) {
        if(i<0){
            if(sum == target){
                return 1;
            } else {
                return 0;
            }
        }

        if(dp[i] != -(int)1e9){
            return dp[i];
        }

        int subtract = helper(nums, target, i-1, sum-nums[i], dp);
        int add = helper(nums,  target, i-1,sum+nums[i], dp);
        return add+subtract;
    }
}
