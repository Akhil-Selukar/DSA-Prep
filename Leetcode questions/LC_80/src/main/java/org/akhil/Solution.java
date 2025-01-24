package org.akhil;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 2;      // because first 2 elements will always be valid (either they can be different or they can be same, both are valid cases)

        for(int i=2; i<nums.length; i++){
            if(nums[count-2] != nums[i]){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
