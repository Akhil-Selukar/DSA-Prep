package org.akhil;

import java.util.Arrays;

public class Solution {

    /**
     * In this particular case because of the nature of constraints memoization is rather slow than actual recursion.
     * Time complexity wise memoization is better (theoretically only because of constraints). If constraints are increased then memoization will help.
     * This is perfect example of how we have to select approach based on constraints.
     * */

    // Solution 1 - Without Memoization
    // O(2^N)/O(N) space call stack is due to recursion call stack
//    public int countMaxOrSubsets(int[] nums) {
//        int maxOR = 0;
//
//        for(int num:nums){
//            maxOR = maxOR | num;
//        }
//
//        // to count the subsets
//        return helper(nums, 0, 0, maxOR);
//    }
//
//    private int helper(int[] nums, int index, int currOR, int maxOR){
//        if (index == nums.length) {
//            if (currOR == maxOR)
//                return 1; // Found one subset
//            return 0;
//        }
//
//        // not take
//        int skip = helper(nums, index+1, currOR, maxOR);
//        // take
//        int take= helper(nums, index+1, currOR | nums[index], maxOR);
//
//        return skip + take;
//    }


    //--------------------
    // Solution 2 - with memoization
    // O(N*MaxOr)/O(N*MaxOr)
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for(int num:nums){
            maxOR = maxOR | num;
        }

        int[][] dp = new int[nums.length][maxOR+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        // to count the subsets
        return helper(nums, 0, 0, maxOR, dp);
    }

    private int helper(int[] nums, int index, int currOR, int maxOR, int[][] dp){
        if (index == nums.length) {
            if (currOR == maxOR)
                return 1; // Found one subset
            return 0;
        }

        if(dp[index][currOR] != -1){
            return dp[index][currOR];
        }

        // not take
        int skip = helper(nums, index+1, currOR, maxOR, dp);
        // take
        int take= helper(nums, index+1, currOR | nums[index], maxOR, dp);

        return dp[index][currOR] = skip + take;
    }
}
