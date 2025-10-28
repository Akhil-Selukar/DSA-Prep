package org.akhil;

public class Solution {
    /**
     * Searches for a target value in an array using the linear search algorithm.
     *
     * @param arr    The array to search in.
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

            if(arr[start] < arr[end]){
                if(arr[mid] < target){
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {
                if(arr[mid] < target){
                    end = mid-1;
                } else {
                    start = start+1;
                }
            }
        }
        return -1;
    }
}
