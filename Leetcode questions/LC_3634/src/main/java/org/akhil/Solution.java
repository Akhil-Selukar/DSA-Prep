package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(NlogN)/O(logN)
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int start = 0;
        int end = 0;
        int result = (int)1e9;

        // after sorting nums[start] will always be the minimum in range start to end and nums[end] will always be maximum
        while(start < n){
            while(end < n && (long)nums[end] <= (long)k*nums[start]){
                end++;
            }

            result = Math.min(result, n-(end-start));
            start++;
        }
        return result;
    }
}
