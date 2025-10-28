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
     *
     * ***** Sample test *****
     * int[] arr = {10, 20, 30, 40, 50, 60, 70};
     * int target = 40;
     *
     * output -> 3
     */

    public int binarySearch(int[] arr, int target){
        // write your code here
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

            if(arr[mid] < target){
                start = start+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }
}
