package org.akhil;

public class Solution {

    /**
     * INSERTION SORT CODE
     * TC - O(N^2)/O(1)
     *
     * Sort the given array using insertion sort
     * In case of empty array or null array do not through exception.
     * @param arr
     */

    public void insertionSort(int[] arr){
        // write your code here
        if(arr == null || arr.length == 0){
            return;
        }

        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
