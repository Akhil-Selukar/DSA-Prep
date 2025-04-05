package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // bruteforce approach - O(N*2^(N))/O(N*2^(N))
//    List<List<Integer>> subsets = new ArrayList<>();
//    public int subsetXORSum(int[] nums) {
//        helper(nums, 0, new ArrayList<Integer>());
//
//        int xorSum = 0;
//
//        for(List<Integer> subset:subsets){
//            int tempSum = 0;
//            for(int num:subset){
//                tempSum = tempSum ^ num;
//            }
//            xorSum = xorSum + tempSum;
//        }
//        return xorSum;
//    }
//
//    private void helper(int[] nums, int index, ArrayList<Integer> temp) {
//        if(index >= nums.length){
//            subsets.add(new ArrayList<>(temp));
//            temp = new ArrayList<Integer>();
//            return;
//        }
//
//        // not take
//        helper(nums, index+1, temp);
//        // take
//        temp.add(nums[index]);
//        helper(nums, index+1, temp);
//        // backtrack
//        temp.remove(temp.size()-1);
//    }

    // Solution 2 - Still recursive solution but a bit optimized (we are not storing subsets)
    // Here as we are not storing subsets hence space complexity for this solution will be O(N) for recursive stack space.
    // O(2^N)/O(N) - time complexity is O(2^N) because we have 2 choices for each element in given array consider and not consider and we are doing recursive calls.
//    public int subsetXORSum(int[] nums) {
//        return helper(nums, 0, 0);
//    }
//
//    private int helper(int[] nums, int index, int total) {
//        if(index >= nums.length){
//            return total;
//        }
//
//        // total at this iteration = consider nums[index] + do not consider nums[i];
//        return helper(nums, index+1, total ^ nums[index]) + helper(nums, index+1, total);
//    }

    // Solution 3 - Mathematical observation and solution
    // O(N)/O(1)
    // check this video for explanation (https://www.youtube.com/watch?v=HToBFhTa1uQ)
    public int subsetXORSum(int[] nums) {
        int orTotal = 0;

        for(int num:nums){
            orTotal = orTotal | num;
        }

        return orTotal * (int)Math.pow(2, nums.length-1);
//        return orTotal << (nums.length-1);
    }

}
