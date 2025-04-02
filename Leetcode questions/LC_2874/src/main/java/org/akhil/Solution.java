package org.akhil;

public class Solution {
    // Solution 1 - O(N)/O(1) (Here there are multiple solutions see LC-2873 (same question different constraints), but all those solutions will give TLE because of constraints)
    public long maximumTripletValue(int[] nums) {
        long maxVal = 0;
        long maxLeftDiff = 0;
        int maxLeftVal = 0;

        for(int i=0; i<nums.length; i++){
            maxVal = (long)Math.max(maxVal, (long)maxLeftDiff*nums[i]);
            maxLeftDiff = (long)Math.max(maxLeftDiff, (long)maxLeftVal-nums[i]);
            maxLeftVal = Math.max(maxLeftVal, nums[i]);
        }

        return maxVal;
    }
}
