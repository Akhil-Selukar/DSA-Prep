package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Solution {

    // Solution 1 - normal recursion (TLE)
//    int maxLength = Integer.MIN_VALUE;
//    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
//
//        helper(nums, target, 0, 0);
//        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
//    }
//
//    private void helper(List<Integer> nums, int target, int index, int count){
//        if(target == 0){
//            maxLength = Math.max(maxLength, count);
//            return;
//        }
//
//        if(index >= nums.size() || target < 0){
//            return;
//        }
//
//        // take curr element
//        helper(nums, target - nums.get(index), index+1, count+1);
//        // skip curr element
//        helper(nums, target, index+1, count);
//    }


    // Solution 2 - Memoization
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size() + 1][target+1];

        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        int maxLength = helper(nums, target, 0, dp);
        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
    }

    private int helper(List<Integer> nums, int target, int index, int[][] dp){
        if(target == 0){
            return 0;
        }

        if(index >= nums.size() || target < 0){
            return Integer.MIN_VALUE;
        }

        if(dp[index][target] != -1){
            return dp[index][target];
        }

        // take curr element
        int takeCount = helper(nums, target - nums.get(index), index+1, dp);
        if(takeCount != Integer.MIN_VALUE){
            takeCount++;
        }

        // skip curr element
        int skipCount = helper(nums, target, index+1, dp);

        return dp[index][target] = Math.max(takeCount, skipCount);
    }
}
