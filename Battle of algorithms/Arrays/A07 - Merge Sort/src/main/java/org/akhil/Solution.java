package org.akhil;

public class Solution {

    /**
     * MERGE SORT CODE
     * Sorts an array of integers using the Merge Sort algorithm.
     *
     * Merge sort uses a recursive helper method which divides the array into two halves, recursively sorts them, and then merges them.
     *
     * TC -> O(NlogN)
     * SC -> O(N)
     *
     * @param arr The array to be sorted.
     */

    public void sort(int[] arr){
        // write your code here
        if(arr == null || arr.length == 0){
            return;
        }

        mergeSort(arr, 0, arr.length);
    }

    private void mergeSort(int[] arr, int start, int end){
        if(end - start == 1){
            return;
        }

        int mid = start + (end-start)/2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end){
        int[] merged = new int[end-start];

        int index = 0;
        int p1 = start;
        int p2 = mid;

        while(p1<mid && p2<end){
            if(arr[p1] < arr[p2]){
                merged[index++] = arr[p1++];
            } else {
                merged[index++] = arr[p2++];
            }
        }

        while(p1<mid){
            merged[index++] = arr[p1++];
        }

        while(p2<end){
            merged[index++] = arr[p2++];
        }

        for(int i=0; i<merged.length; i++){
            arr[start+i] = merged[i];
        }
    }
}
