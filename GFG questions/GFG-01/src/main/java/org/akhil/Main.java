package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        printSumTriangle(arr);
    }

    private static void printSumTriangle(int[] arr) {
        if(arr.length<1){
            return;
        }
        int[] stepResult = new int[arr.length-1];

        for(int i=0; i<arr.length-1; i++){
            stepResult[i] = arr[i]+arr[i+1];
        }
        printSumTriangle(stepResult);
        System.out.println(Arrays.toString(arr));
    }
}