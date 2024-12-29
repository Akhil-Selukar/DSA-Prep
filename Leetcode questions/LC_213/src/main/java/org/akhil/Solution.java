package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution - 1 (will give TLE)
//    public int rob(int[] nums) {
//        if (nums.length == 1) return nums[0];
//        return Math.max(rob(nums, nums.length - 2, 0), rob(nums, nums.length-1, 1));
//    }
//
//    private int rob(int[] nums, int i, int end)  {
//        if(i < end){
//            return 0;
//        }
//        return Math.max(rob(nums, i-1, end), nums[i]+rob(nums, i-2, end));
//    }

    // Solution 2 - Memoization
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int right = rob(nums, nums.length - 2, 0, memo);
        Arrays.fill(memo, -1);      // here we have to reinitialize the memoization array because the values calculated during right recursion call was excluding last element now we want to calculate including it so variables/initial conditions are changed hence values will also change.
        int left = rob(nums, nums.length - 1, 1, memo);
        return Math.max(right, left);
    }

    private int rob(int[] nums, int i, int end, int[] memo)  {
        if(i < end){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }
        int left = nums[i]+rob(nums, i-2, end, memo);
        int right = rob(nums, i-1, end, memo);
        return memo[i] = Math.max(left, right);
    }
}
