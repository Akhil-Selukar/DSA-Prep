package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,2,9,16,19,15,4};
        int target = 9;

        System.out.println(lSearch(arr, target));
    }

    public static int lSearch(int[] arr, int target) {
        int startIndex = 0;
        return searchTarget(arr, target, startIndex);
    }

    private static int searchTarget(int[] arr, int target, int startIndex) {
        if(startIndex > arr.length-1){
            return -1;
        }

        if(arr[startIndex] == target){
            return startIndex;
        }
        return searchTarget(arr, target, startIndex+1);
    }
}