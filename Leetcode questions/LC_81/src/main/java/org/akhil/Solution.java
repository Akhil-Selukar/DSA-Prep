package org.akhil;

public class Solution {
    public boolean search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if (nums[midIndex] == target){
                return true;
            }

            if (nums[startIndex] == nums[midIndex]) {
                startIndex++;
                continue;
            }

            if (nums[startIndex] <= nums[midIndex]) {
                if (nums[startIndex] <= target && target <= nums[midIndex]) endIndex = midIndex - 1;
                else startIndex = midIndex + 1;
            } else {
                if (nums[midIndex] <= target && target <= nums[endIndex]) startIndex = midIndex + 1;
                else endIndex = midIndex - 1;
            }
        }
        return false;
    }
}
