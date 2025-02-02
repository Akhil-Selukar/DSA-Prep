package org.akhil;

public class Solution {

    // O(N)/O(1)
    public void moveZeroes(int[] nums) {
        //{0,1,0,3,12}
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
