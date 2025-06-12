package org.akhil;

public class Solution {

    // O(N)/O(1)
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int diff = Math.abs(nums[i] - (i == n-1 ? nums[0] : nums[i+1]));

            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }
}
