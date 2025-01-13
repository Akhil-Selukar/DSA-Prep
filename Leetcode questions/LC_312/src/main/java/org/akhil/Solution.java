package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // Solution 1 - Normal recursion
//    public int maxCoins(int[] arr) {
//        // we need to add trailing and leading 1 hence converting array to list.
//        // (We can use array as well, just shift the array right by 1 place add 0th index as 1 and last index as 1)
//        List<Integer> nums = new ArrayList<>();
//        for(int num:arr){
//            nums.add(num);
//        }
//        nums.add(0,1);      // trailing 1
//        nums.add(1);                     // leading 1
//
//        return helper(nums, 1, arr.length);         // start index is 1 because we have added extra element at index 0. and end index is also arr.length (not nums.size()) because nums.size() will be of modified values
//    }
//
//    private int helper(List<Integer> nums, int leftBoundary, int rightBoundary) {
//        // base condition
//        if(leftBoundary > rightBoundary){
//            return 0;
//        }
//
//        int maxCoins = Integer.MIN_VALUE;
//        for(int k=leftBoundary; k<=rightBoundary; k++){
//            int currentCoins = nums.get(leftBoundary-1) * nums.get(k) * nums.get(rightBoundary+1)       // as we are bursting kth balloon last hence left and right boundary will be 1 (i.e. the extra added 1's)
//                    + helper(nums, leftBoundary, k-1)                  // left side sub-problem will have new limits. Left limit will remain as it is but right limit will be the balloon we will be bursting last-1.
//                    + helper(nums, k+1, rightBoundary);                  // right side sub-problem will have new limits. right limit will remain same but left limit will be balloon we will be bursting last + 1
//
//            maxCoins = Math.max(maxCoins, currentCoins);
//        }
//        return maxCoins;
//    }

    // Solution 2 - Memoization
    public int maxCoins(int[] arr) {
        // we need to add trailing and leading 1 hence converting array to list.
        // (We can use array as well, just shift the array right by 1 place add 0th index as 1 and last index as 1)
        List<Integer> nums = new ArrayList<>();
        for(int num:arr){
            nums.add(num);
        }
        nums.add(0,1);      // trailing 1
        nums.add(1);                     // leading 1

        int[][] dp = new int[nums.size()][nums.size()];     // dp array will have size as nums.size() as in dp array we need to consider additional additions of 1's as well.
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        return helper(nums, 1, arr.length, dp);         // start index is 1 because we have added extra element at index 0. and end index is also arr.length (not nums.size()) because nums.size() will be of modified values
    }

    private int helper(List<Integer> nums, int leftBoundary, int rightBoundary, int[][] dp) {
        // base condition
        if(leftBoundary > rightBoundary){
            return 0;
        }

        if(dp[leftBoundary][rightBoundary] != -1){
            return dp[leftBoundary][rightBoundary];
        }

        int maxCoins = Integer.MIN_VALUE;
        for(int k=leftBoundary; k<=rightBoundary; k++){
            int currentCoins = nums.get(leftBoundary-1) * nums.get(k) * nums.get(rightBoundary+1)       // as we are bursting kth balloon last hence left and right boundary will be 1 (i.e. the extra added 1's)
                    + helper(nums, leftBoundary, k-1, dp)                  // left side sub-problem will have new limits. Left limit will remain as it is but right limit will be the balloon we will be bursting last-1.
                    + helper(nums, k+1, rightBoundary, dp);                  // right side sub-problem will have new limits. right limit will remain same but left limit will be balloon we will be bursting last + 1

            maxCoins = Math.max(maxCoins, currentCoins);
        }
        return dp[leftBoundary][rightBoundary] = maxCoins;
    }
}
