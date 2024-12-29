package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 : This is correct but will give TLE because of multiple repetitive recursive calls
//    public int rob(int[] nums) {
//        return robHelper(nums.length-1, nums);
//    }
//
//    private int robHelper(int i, int[] nums) {
//        if(i < 0){
//            return nums[i];
//        }
//        return Math.max(nums[i] + robHelper(i-2, nums), robHelper(i-1, nums));
//    }

    // Solution 2 - Using Memoization (This solution will work, but we can still optimize it further)
//    public int rob(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//        return robHelper(nums.length-1, nums, dp);
//    }
//
//    private int robHelper(int i, int[] nums, int[] dp) {
//        if(i < 0){
//            return 0;
//        }
//        if(dp[i] != -1){
//            return dp[i];
//        }
//        return dp[i] = Math.max(nums[i] + robHelper(i-2, nums, dp), robHelper(i-1, nums, dp));
//    }

    // Solution 3 : tabulation
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;    // skipped the adjacent
        dp[1] = nums[0];    // direct adjacent

        for(int i=1; i<nums.length; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        }

        return dp[nums.length];
    }
}
