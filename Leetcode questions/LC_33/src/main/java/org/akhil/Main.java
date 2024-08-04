package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
//        int[] nums = {1,3};
//        int target = 1;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivotIndex(nums);
        int targetIndex = -1;
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length-1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot-1);
        }
        return binarySearch(nums, target,  pivot+1, nums.length-1);
    }

    private static int binarySearch(int[] nums, int target, int startIndex, int endIndex){
        while(startIndex<=endIndex){
            int midIndex = startIndex + (endIndex-startIndex)/2;

            if(target<nums[midIndex]){
                endIndex = midIndex-1;
            } else if(target > nums[midIndex]){
                startIndex = startIndex+1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

    private static int findPivotIndex(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length-1;

        while(startIndex<=endIndex){
            int midIndex = startIndex + (endIndex-startIndex)/2;

            if(midIndex<endIndex && nums[midIndex]>nums[midIndex+1]){
                return midIndex;
            } else if(midIndex>startIndex && nums[midIndex]<nums[midIndex-1]){
                return midIndex-1;
            }

            if(nums[midIndex]<=nums[startIndex]){
                endIndex = midIndex-1;
            } else {
                startIndex = midIndex+1;
            }
        }
        return -1;
    }
}