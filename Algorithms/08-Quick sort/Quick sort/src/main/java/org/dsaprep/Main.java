package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 6, 1, 8, 12};
        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    protected static void quickSort(int[] arr, int startIndex, int endIndex) {
        if(startIndex>=endIndex){
            return;
        }

        int startPointer = startIndex;
        int endPointer = endIndex;
        int midPointer = startPointer + (endPointer - startPointer)/2;
        int pivotElement = arr[midPointer];

        while(startPointer <= endPointer){
            // check violation in LHS of pivot
            while(arr[startPointer] < pivotElement){
                startPointer++;
            }

            // check violation in RHS of pivot
            while(arr[endPointer] > pivotElement){
                endPointer--;
            }

            if(startPointer<=endPointer){
                int temp = arr[startPointer];
                arr[startPointer] = arr[endPointer];
                arr[endPointer] = temp;
                startPointer++;
                endPointer--;
            }
        }

        // after completing for first pivot, do two recursion calls for LHS and RHS of pivot and sort both the sides.
        quickSort(arr, startIndex, endPointer);
        quickSort(arr, startPointer, endIndex);
    }
}