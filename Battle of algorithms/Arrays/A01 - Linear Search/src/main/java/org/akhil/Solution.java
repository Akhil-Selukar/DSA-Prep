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
    public int linearSearch(int[] arr, int target){
        // Write your code here.
        if(arr == null){
            return -1;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
