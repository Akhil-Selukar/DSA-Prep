package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,1,5,6,2,4};

        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    public static int[] insertionSort(int[] arr){
        for(int i=0; i < arr.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(arr[j]<arr[j-1]){
                    swapElements(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    private static void swapElements(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i]=temp;
    }
}