package org.akhil;

public class Solution {
    public int minOperations(int[] nums){
        int index = 0;
        int n = nums.length;
        int count = 0;

        while(index < n-2){
            if(nums[index] == 0){
                nums[index] ^= 1;
                nums[index+1] ^= 1;
                nums[index+2] ^= 1;
                count++;
            }
            index++;
        }

        if(nums[index] == 0 || nums[index+1] == 0){
            return -1;
        }
        return count;
    }
}
