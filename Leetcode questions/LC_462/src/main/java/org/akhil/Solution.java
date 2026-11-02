package org.akhil;

import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = 0;

        for(int i=0; i<n/2; i++){
            result = result + Math.abs(nums[i] - nums[n/2]);
            result = result + Math.abs(nums[n-1-i] - nums[n/2]);
        }

        return result;
    }
}