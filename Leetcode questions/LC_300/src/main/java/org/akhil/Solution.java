package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion
//    public int lengthOfLIS(int[] nums) {
//        return helper(nums, 0, -1);
//    }
//
//    private int helper(int[] nums, int index, int previousIndex) {
//        if(index == nums.length){
//            return 0;
//        }
//
//        int take= 0;
//        if(previousIndex == -1 || nums[previousIndex]<nums[index]) {
//            take = 1+helper(nums, index+1, index);
//        }
//        int notTake = helper(nums, index+1, previousIndex);
//
//        return Math.max(take, notTake);
//    }

    // Solution 2 - Memoization
//    public int lengthOfLIS(int[] nums) {
//        int[][] dp = new int[nums.length][nums.length+1];
//        for(int[] arr:dp){
//            Arrays.fill(arr, -1);
//        }
//        return helper(nums, 0, -1, dp);
//    }
//
//    private int helper(int[] nums, int index, int previousIndex, int[][] dp) {
//        if(index == nums.length){
//            return 0;
//        }
//
//        if(dp[index][previousIndex+1] != -1){
//            return dp[index][previousIndex+1];
//        }
//        int take= 0;
//        if(previousIndex == -1 || nums[previousIndex]<nums[index]) {
//            take = 1+helper(nums, index+1, index, dp);
//        }
//        int notTake = helper(nums, index+1, previousIndex, dp);
//
//        return dp[index][previousIndex+1] = Math.max(take, notTake);
//    }

    // Solution 3 - Tabulation
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n];      // to store length of LIS till specific index
        Arrays.fill(dp, 1);
        int maxLength = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
