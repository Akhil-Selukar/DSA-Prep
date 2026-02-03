package org.akhil;

public class Solution {
    // O(N)/O(1)
    public boolean isTrionic(int[] nums) {
        int index = 1;

        // check if we are following increasing order or not
        while(index < nums.length && nums[index] > nums[index-1]){
            index++;
        }

        // check if no increasing order is found or all elements are in increasing order
        // index == 1 means no increasing order
        // index == length means no scope left for decreasing order
        if(index == 1 || index == nums.length){
            return false;
        }

        // check for decreasing order
        while(index < nums.length && nums[index] < nums[index-1]){
            index++;
        }

        // if entire array is traversed and no element is remaining for another increasing order
        if(index == nums.length){
            return false;
        }

        // check final increasing order
        while(index < nums.length && nums[index] > nums[index-1]){
            index++;
        }

        if(index == nums.length){
            return true;
        }

        return false;
    }
}
