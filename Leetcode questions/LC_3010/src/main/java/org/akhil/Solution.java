package org.akhil;

public class Solution {

    // O(N)/O(1)
    public int minimumCost(int[] nums) {
        // As we need to divide the array in 3 subarrays so we will need to perform two splits.
        // The cost is always the first value in each subarray so the first element in given array will always be the cost of one subarray.
        // Now for remaining two as we need to minimize the sum so we need to perform split at lowest values after first value in given array.
        // So in short the question turns into find the two minimum in the given array starting from index 1 till n.

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i=1; i<nums.length; i++){
            if(min1 > nums[i] || min2 > nums[i]){
                min1 = Math.min(min1, min2);
                min2 = nums[i];
            }
        }

        return nums[0] + min1 + min2;
    }
}
