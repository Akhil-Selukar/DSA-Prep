package org.akhil;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        // use redix sort here
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;

        for(int i=1; i<nums.length; i++){
            max = Math.max(max, nums[i]-nums[i-1]);
        }
        return max;
    }
}
