package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, -4, 8, 6};

        System.out.println(printMin(arr, arr.length-1));
        System.out.println(printMax(arr, arr.length-1));
    }

    protected static int printMin(int[] arr, int endIndex) {
        if(endIndex == 0){
            return arr[endIndex];
        }

        return Math.min(arr[endIndex], printMin(arr, endIndex-1));
    }

    protected static int printMax(int[] arr, int endIndex) {
        if(endIndex == 0){
            return arr[endIndex];
        }

        return Math.max(arr[endIndex], printMax(arr, endIndex-1));
    }
}