package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};

        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    public static int[] selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int end = arr.length -1 - i; // this is because after every iteration we want to ignore the last element as it will be already at its correct position.
            int start = 0; // every iteration we will start from 0;

            int maxIndex = findMaxValueIndex(arr, start, end); // find index of maximum value
            swaIndex(arr, maxIndex, end); // swap the maxvalue with last value of current active array.
        }
        return arr;
    }

    private static int findMaxValueIndex(int[] arr, int start, int end) {
        int maxIndex = start;
        for(int i=0; i<=end; i++){
            if(arr[i]>arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static void swaIndex(int[] arr, int maxIndex, int end) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[end];
        arr[end] = temp;
    }
}