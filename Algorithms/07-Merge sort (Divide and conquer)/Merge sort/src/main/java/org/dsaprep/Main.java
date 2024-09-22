package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // This is also called as divide and conquer
        int[] arr = {5, 3, 4, 6, 1, 8, 12};

        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    // This approach of merge sort is not good in terms of space complexity as we are creating a new copy of array every time we are
    // dividing the array in two parts, also sorted array is an additional array created in memory to store the sorted array.
    // we can modify this code and do the sorting in place (i.e. withing the given array)

    protected static int[] mergeSort(int[] arr) {
        // Base condition
        if (arr.length == 1) {
            return arr;
        }

        // Divide the array in two parts
        int midIndex = arr.length / 2;

        // Sort both the half
        int[] firstHalf = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] secondHalf = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

        // Merge the sorted two parts
        return merge(firstHalf, secondHalf);
    }

    private static int[] merge(int[] firstHalf, int[] secondHalf) {
        int[] resultArr = new int[firstHalf.length + secondHalf.length];
        int firstHalfPointer = 0;
        int secondHalfPointer = 0;
        int resultArrPointer = 0;

        while(firstHalfPointer < firstHalf.length && secondHalfPointer < secondHalf.length){
            if(firstHalf[firstHalfPointer] < secondHalf[secondHalfPointer]){
                resultArr[resultArrPointer] = firstHalf[firstHalfPointer];
                firstHalfPointer++;
            } else {
                resultArr[resultArrPointer] = secondHalf[secondHalfPointer];
                secondHalfPointer++;
            }
            resultArrPointer++;
        }

        // In case of one of the array is out of elements, add all elements in another array. (as they are already sorted)
        while(firstHalfPointer<firstHalf.length){
            resultArr[resultArrPointer] = firstHalf[firstHalfPointer];
            firstHalfPointer++;
            resultArrPointer++;
        }

        while(secondHalfPointer<secondHalf.length){
            resultArr[resultArrPointer] = secondHalf[secondHalfPointer];
            secondHalfPointer++;
            resultArrPointer++;
        }
        return resultArr;
    }
}