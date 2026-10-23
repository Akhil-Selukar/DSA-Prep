package org.akhil;

public class Solution {
    public int sortPermutation(int[] nums) {
        int kMax = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != i){
                kMax = kMax & nums[i];
            }
        }
        return kMax == Integer.MAX_VALUE ? 0 : kMax;
    }
}
