package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Here we are not creating additional sub-array for each recursion call.
        int[] arr = {5, 3, 4, 6, 1, 8, 12};
        mergeSortInPlace(arr, 0, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    protected static void mergeSortInPlace(int[] arr, int startIndex, int endIndex) {
        if(endIndex - startIndex == 1){
            return;
        }

        int midIndex = startIndex + (endIndex - startIndex)/2;

        mergeSortInPlace(arr, startIndex, midIndex);
        mergeSortInPlace(arr, midIndex, endIndex);

        mergeInPlace(arr, startIndex, midIndex, endIndex);
    }

    private static void mergeInPlace(int[] arr, int startIndex, int midIndex, int endIndex) {
        int[] merged = new int[endIndex - startIndex];

        int firstIndex = startIndex;
        int secondIndex = midIndex;
        int resultIndex = 0;

        while(firstIndex < midIndex && secondIndex < endIndex){
            if(arr[firstIndex] < arr[secondIndex]){
                merged[resultIndex] = arr[firstIndex];
                firstIndex++;
            } else {
                merged[resultIndex] = arr[secondIndex];
                secondIndex++;
            }
            resultIndex++;
        }

        while(firstIndex<midIndex){
            merged[resultIndex] = arr[firstIndex];
            firstIndex++;
            resultIndex++;
        }

        while(secondIndex<endIndex){
            merged[resultIndex] = arr[secondIndex];
            secondIndex++;
            resultIndex++;
        }

        // modify the original array with sorted value
        for(int i = 0; i<merged.length; i++){
            arr[startIndex+i] = merged[i];
        }
    }
}