package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,4,8,2,1,9,16,12,10,52,23,24,20};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    protected static void selectionSort(int[] arr) {
        sortingHelper(arr, arr.length, 1, 0);
    }

    private static void sortingHelper(int[] arr, int length, int currentIndex, int maxIndex) {
        if(length == 0){
            return;
        }

        if(currentIndex < length){
            if(arr[currentIndex] > arr[maxIndex]){
                sortingHelper(arr, length, currentIndex+1, currentIndex);
            } else {
                sortingHelper(arr, length, currentIndex+1, maxIndex);
            }
        } else {
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[length-1];
            arr[length-1] = temp;
            sortingHelper(arr, length-1, 0,0);
        }
    }
}