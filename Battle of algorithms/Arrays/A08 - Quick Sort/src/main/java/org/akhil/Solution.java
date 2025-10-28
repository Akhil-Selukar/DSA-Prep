package org.akhil;

public class Solution {

    /**
     * QUICK SORT CODE
     *
     * Sorts an array of integers using the Quick Sort algorithm.
     * Quick sort use a pivot element and ensure all array elements less than pivot elements are on LHS of pivot and all elements greater than pivot are
     * on RHS of pivot. Perform this operation recursively on LHS and RHS till we are left with individual element in sorted order
     *
     * TC -> O(N^2) in worst case O(NlogN) in average case
     * SC -> O(N) due to recursive call stack
     *
     * @param arr The array to be sorted.
     */
    public void sort(int[] arr){
        // write your code here
        if(arr == null || arr.length == 0){
            return;
        }

        quickSort(arr, 0, arr.length-1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if(start >= end){
            return;
        }

        int startIndex = start;
        int endIndex = end;
        int mid = start + (end-start)/2;
        int pivot = arr[mid];

        while(startIndex <= endIndex){
            while(arr[startIndex] < pivot){
                startIndex++;
            }

            while(arr[endIndex] > pivot){
                endIndex--;
            }

            if(startIndex <= endIndex){
                int temp = arr[startIndex];
                arr[startIndex] = arr[endIndex];
                arr[endIndex] = temp;

                startIndex++;
                endIndex--;
            }
        }

        quickSort(arr, start, endIndex);
        quickSort(arr, startIndex, end);
    }
}
