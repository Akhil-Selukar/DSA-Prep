package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,4,8,2,1,9,16,12,10,52,23,24,20};

        System.out.println(Arrays.toString(bSort(arr)));
    }

    protected static int[] bSort(int[] arr) {
        return sortingHelper(arr, arr.length-1, 0);
    }

    private static int[] sortingHelper(int[] arr, int length, int columnIndex) {
        if(length == 0){
            return arr;
        }
        if(length == columnIndex){
            return sortingHelper(arr, length-1, 0);
        }else if(arr[columnIndex] > arr[columnIndex+1]){
            swap(arr, columnIndex);
        }
        return sortingHelper(arr, length, columnIndex+1);
    }

    private static void swap(int[] arr, int columnIndex) {
        int temp = arr[columnIndex+1];
        arr[columnIndex+1] = arr[columnIndex];
        arr[columnIndex] = temp;
    }
}