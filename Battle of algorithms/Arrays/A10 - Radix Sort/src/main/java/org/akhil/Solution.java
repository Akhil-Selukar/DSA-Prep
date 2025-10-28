package org.akhil;

import java.util.Arrays;

public class Solution {
    /**
     * RADIX SORT CODE
     * Sorts given array of non-negative integers using the Radix Sort algorithm.
     *
     * Radix sort uses a helper method that performs Count Sort on the array based on the digit at place represented by 'place'.
     *
     * TC -> O(KN) where K is number of digits in largest number of given array and N is length of given array
     * SC -> O(N) to store result array
     *
     * @param arr The array to sort
     * @throws IllegalArgumentException In case of array has -ve number
     */
    public void radixSort(int[] arr) throws IllegalArgumentException {
        // Write your code here
        if(arr == null || arr.length == 0){
            return;
        }

        int max = 0;
        for(int val:arr){
            if(val < 0){
                throw new IllegalArgumentException("Not allowed");
            }
            max = Math.max(max, val);
        }

        int place = 1;
        while(max/place > 0){
            countSort(arr, place);
            place = place*10;
        }
    }

    private void countSort(int[] arr, int place){
        int[] sorted = new int[arr.length];

        int[] count = new int[10];

        for(int val:arr){
            count[(val/place)%10]++;
        }

        // calculate prefix sum
        for(int i=1; i<10; i++){
            count[i] = count[i-1] + count[i];
        }

        // sort the array
        for(int i=arr.length-1; i>=0; i--){
            int index = count[(arr[i]/place)%10]-1;
            sorted[index] = arr[i];
            count[(arr[i]/place)%10]--;
        }

        // sort the original based on this iteration
        for(int i=0; i<arr.length; i++){
            arr[i] = sorted[i];
        }
    }
}
