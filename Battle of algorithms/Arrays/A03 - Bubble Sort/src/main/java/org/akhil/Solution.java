package org.akhil;

public class Solution {

    /**
     * Sort the given array in ascending order
     *
     * @param arr    The array to sort.
     * @return The sorted array.
     *
     * @author Akhil Selukar
     *
     * ********** Complexity analysis ********
     * Time complexity -> O(N^2)
     * Space complexity -> O(1)
     */

    public int[] bubbleSort(int[] arr) {
        // write your code here.
        if(arr == null){
            return arr;
        }

        for(int i=0; i<arr.length; i++){
            boolean swapped = false;
            for(int j=1; j<arr.length-i; j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return arr;
    }
}
