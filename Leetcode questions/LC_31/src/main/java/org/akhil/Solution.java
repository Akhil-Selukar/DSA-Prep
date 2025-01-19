package org.akhil;

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // find the breakpoint
        int breakPoint = -1;
        for(int i=n-1; i>0; i--){
            if(nums[i]>nums[i-1]){
                breakPoint = i-1;
                break;
            }
        }

        if(breakPoint == -1){
            reverseArray(nums, 0, n-1);
            return;
        }

        // find smallest element greater than nums[breakPoint] from [breakpoint+1, end]
        // start checking from backward because if there are duplicates at the end then we need to swap last duplicate.
        int smallest = findSmallest(nums, breakPoint, n-1);

        // swap breakpoint with smallestIndex
        int temp = nums[breakPoint];
        nums[breakPoint] = nums[smallest];
        nums[smallest] = temp;

        // reverse the array AFTER breakPoint
        reverseArray(nums, breakPoint+1, n-1);
    }

    private int findSmallest(int[] nums, int start, int end) {
        int smallestIndex = end;
        for(int i=end; i>=start; i--){
            if(nums[i]>nums[start]){
                smallestIndex = i;
                break;
            }
        }
        return smallestIndex;
    }

    private void reverseArray(int[] nums, int start, int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
