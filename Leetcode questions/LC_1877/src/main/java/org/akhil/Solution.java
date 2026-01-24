package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(NlogN)/O(1)
    public int minPairSum(int[] nums) {
        // Thought process 1 -> If we want the maximum sum to be minimized then it can only be achieved by adding the
        // maximum value in the minimum value from given set of values. So we can simply sort the given arrays and take
        // first and last value from sorted array and return their sum.
        // Thought process 2 -> Based on pure observation, if we see 2nd test case and the pairs formed in it. We can clearly
        // observe that the largest value is paired with smallest value, Second largest value is paired with second smallest
        // and so on. So we can do the same and get the minimized maximum sum.

        // Edge case: [4,1,5,1,2,5,1,5,5,4]
        // due to multiple repeated elements after sorting the array it will become [1,1,1,2,4,4,5,5,5,5]
        // So if we see the maximized minimum sum it will not be 6 (i.e. 1+5) but it will be 8 (4+4) hence we can't just
        // return sum of first and last, we need to check all pair's sum.

        int n = nums.length;
        Arrays.sort(nums);

        int start = 0;
        int end = n-1;
        int result = 0;

        while(start < end){
            result = Math.max(result, nums[start]+nums[end]);
            start++;
            end--;
        }

        return result;
    }
}
