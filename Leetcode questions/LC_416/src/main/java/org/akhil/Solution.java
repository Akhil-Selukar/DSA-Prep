package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion
//    public boolean canPartition(int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        if(sum % 2 != 0){
//            return false;
//        }
//        int target = sum/2;
//
//        return partitioningHelper(nums, nums.length-1 ,target);
//    }
//
//    private boolean partitioningHelper(int[] nums, int index, int target){
//        if(target == 0){
//            return true;
//        }
//        if(0 > target){
//            return false;
//        }
//        if(index == 0){
//            return nums[0] == target;
//        }
//
//        return partitioningHelper(nums, index-1, target-nums[index]) || partitioningHelper(nums, index-1, target);
//    }

    // Solution 2 - Memoization
//    public boolean canPartition(int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        if(sum % 2 != 0){
//            return false;
//        }
//        int target = sum/2;
//        int[][] dp = new int[nums.length][target+1];
//        for(int[] arr:dp){
//            Arrays.fill(arr, -1);
//        }
//
//        return partitioningHelper(nums, nums.length-1 ,target, dp);
//    }
//
//    private boolean partitioningHelper(int[] nums, int index, int target, int[][] dp){
//        if(target == 0){
//            return true;
//        }
//        if(0 > target){
//            return false;
//        }
//        if(index == 0){
//            return nums[0] == target;
//        }
//
//        if(dp[index][target] != -1){
//            return dp[index][target] == 1;
//        }
//
//        if(partitioningHelper(nums, index-1, target-nums[index], dp) || partitioningHelper(nums, index-1, target, dp)){
//            dp[index][target] = 1;
//            return true;
//        }
//        dp[index][target] = 0;
//        return false;
//    }

    // Solution 3 - Memoization optimized
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Boolean[] dp = new Boolean[target + 1];

        return partitioningHelper(nums, nums.length - 1, target, dp);
    }

    private boolean partitioningHelper(int[] nums, int index, int target, Boolean[] dp) {
        if (target == 0) {
            return true;
        }
        if (0 > target) {
            return false;
        }
        if (index == 0) {
            return nums[0] == target;
        }

        if (dp[target] != null) {
            return dp[target];
        }

        return dp[target] = partitioningHelper(nums, index - 1, target - nums[index], dp) || partitioningHelper(nums, index - 1, target, dp);
    }
}
