package org.akhil;

public class Solution {

    // O(N)/O(1)
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return true;
        }

        int violations = 0;
        for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                violations++;

                if(violations > 1){
                    return false;
                }

                if(i == 0 || nums[i-1] <= nums[i+1]){
                    nums[i] = nums[i+1];
                } else {
                    nums[i+1] = nums[i];
                }
            }
        }
        return true;
    }
}
