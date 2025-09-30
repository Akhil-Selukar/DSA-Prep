package org.akhil;

public class Solution {
    // O(N^2)/O(1)
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        int step = 0;
        while(step < n){
            for(int i=0; i<n-step-1; i++){
                nums[i] = (nums[i]+nums[i+1])%10;
            }
            step++;
        }

        return nums[0];
    }
}
