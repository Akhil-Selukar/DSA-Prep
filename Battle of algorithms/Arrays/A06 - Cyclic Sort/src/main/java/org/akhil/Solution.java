package org.akhil;

public class Solution {

    /**
     * CYCLIC SORT CODE
     * Cyclic sort works when array elements are in the range of 1 to N;
     * TC -> O(N)
     * SC -> O(1)
     *
     * Sort the given array
     * Handle null and empty array (It should not throw exception)
     * @param arr
     */

    public void cyclicSort(int[] arr){
        // write your code here
        if(arr == null || arr.length == 0){
            return;
        }

        int i=0;
        while(i<arr.length){
            int correctIndex = arr[i]-1;
            if(correctIndex != i){
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }
    }
}
