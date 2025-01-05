package org.akhil;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Integer> dp = new HashMap<>();
        return helper(nums, target, nums.length-1, 0, dp);
    }

    private int helper(int[] nums, int target, int i, int sum, Map<String, Integer> dp) {
        if(i<0){
            if(sum == target){
                return 1;
            } else {
                return 0;
            }
        }

        String key=i+":"+sum;
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        int subtract = helper(nums, target, i-1, sum-nums[i], dp);
        int add = helper(nums,  target, i-1,sum+nums[i], dp);
        dp.put(key, add+subtract);
        return add+subtract;
    }
}
