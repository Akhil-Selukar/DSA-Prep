package org.akhil;

public class Solution {
    /**
     * Sort the given array using selection sort
     *      -> consider entire array from start to end
     *      -> find index of the largest array (i.e. selection of largest element)
     *      -> put it at its appropriate place (i.e. end)
     *      -> shrink the range to end-1
     *
     * @param arr    The array to search in.
     * @return sorted array
     *
     * @author Akhil Selukar
     *
     * Time complexity -> O(N^2)
     * Space complexity -> O(1)
     */

    public int[] selectionSort(int[] arr){
       // write your code here.
        if(arr == null){
            return arr;
        }

        for(int i=0; i<arr.length; i++){
            int start = 0;
            int end = arr.length-i-1;
            int maxIndex = getMaxIndex(arr, start, end);

            int temp = arr[end];
            arr[end] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        return arr;
    }

    private int getMaxIndex(int[] arr, int start, int end) {
        int maxIndex = start;
        for(int i=start; i<=end; i++){
            if(arr[maxIndex] < arr[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
