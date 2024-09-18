package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,5,6,9,12,16};

        System.out.println(isSorted(arr));
    }

    public static boolean isSorted(int[] arr) {
        int startIndex = 0;
        return checkIfSorted(arr, startIndex);
    }

    private static boolean checkIfSorted(int[] arr, int startIndex) {
        if(startIndex == arr.length-1){
            return true;
        }
        if(arr[startIndex] <= arr[startIndex+1]){
            return (arr[startIndex] <= arr[startIndex+1]) && checkIfSorted(arr, startIndex+1);
        } else {
            return false;
        }

    }
}