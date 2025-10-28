package org.akhil;

public class Solution {
    /**
     * Searches for a target value in a sorted array that has been rotated.
     * The array is sorted but shifted.
     *
     * @param arr    The rotated sorted array to search in.
     * @param target The value to search for.
     * @return The index of the target if found, otherwise -1.
     *
     * @author Akhil Selukar
     */
    public int binarySearch(int[] arr, int target){
        // Write your code here
        if(arr == null){
            return -1;
        }

        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target){
                return mid;
            }

            if(arr[start] <= arr[mid]){
                if(arr[start] <= target && target < arr[mid]){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if(arr[mid] < target && target <= arr[end]){
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }

        return -1;
    }
}
