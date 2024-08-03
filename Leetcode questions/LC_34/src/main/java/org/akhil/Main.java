package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int startIndex = 0;
        int endIndex = nums.length-1;
        int ansStart = -1;
        int ansEnd = -1;

        // Finding start index of target
        while(startIndex<=endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(target < nums[midIndex]){
                endIndex = midIndex - 1;
            } else if(target > nums[midIndex]){
                startIndex = midIndex+1;
            } else {
                ansStart = midIndex;
                endIndex = midIndex - 1;
            }
        }

        startIndex = 0;
        endIndex = nums.length-1;
        // Finding end index of target
        while(startIndex<=endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(target < nums[midIndex]){
                endIndex = midIndex - 1;
            } else if(target > nums[midIndex]){
                startIndex = midIndex+1;
            } else {
                ansEnd = midIndex;
                startIndex = midIndex+1;
            }
        }

        ans[0] = ansStart;
        ans[1] = ansEnd;
        return ans;
    }
}