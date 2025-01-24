package org.akhil;

public class Solution {
    public void sortColors(int[] nums) {
        // Solution 1 - insertion sort O(N^2)
//        int n = nums.length;
//
//        for(int i=0; i<n-1; i++){
//            for(int j=i+1; j>0; j--){
//                if(nums[j] < nums[j-1]){
//                    int temp = nums[j];
//                    nums[j] = nums[j-1];
//                    nums[j-1] = temp;
//                }
//            }
//        }


        // solution 2 - Quick sort O(N log(N))
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int startIndex, int endIndex) {
        if(startIndex>=endIndex){
            return;
        }

        int startPointer = startIndex;
        int endPointer = endIndex;

        int midIndex = startPointer + (endPointer - startPointer)/2;
        int pivotElement = nums[midIndex];

        while(startPointer <= endPointer){
            // check violation in LHS of pivot
            while(nums[startPointer] < pivotElement){
                startPointer++;
            }

            // check violation in RHS of pivot
            while(nums[endPointer] > pivotElement){
                endPointer--;
            }

            if(startPointer<=endPointer){
                int temp = nums[startPointer];
                nums[startPointer] = nums[endPointer];
                nums[endPointer] = temp;
                startPointer++;
                endPointer--;
            }
        }

        quickSort(nums, startIndex, endPointer);
        quickSort(nums, startPointer, endIndex);
    }
}
