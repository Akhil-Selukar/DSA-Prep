package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int longestMonotonicSubarray(int[] nums) {
        int result = 1;
        int curr = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i]-nums[i-1] >= 1){
                curr++;
                result = Math.max(result, curr);
            } else {
                curr = 1;
            }
        }

        curr = 1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]-nums[i+1] >= 1){
                curr++;
                result = Math.max(result, curr);
            } else {
                curr = 1;
            }
        }
        return result;
    }
}
