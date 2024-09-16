package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 9, 16, 18, 26, 35, 49, 56};
        int target  = 49; // 8

        int ans = bSearch(arr, target, 0, arr.length-1);
        System.out.println(ans);
    }

    private static int bSearch(int[] arr, int target, int startIndex, int endIndex) {
        if(startIndex > endIndex){
            return -1;
        }

        int middleIndex = startIndex + (endIndex - startIndex)/2;

        if(arr[middleIndex] == target){
            return middleIndex;
        }
        if(arr[middleIndex] < target){
            return bSearch(arr, target, middleIndex+1, endIndex);
        }
        return bSearch(arr, target, startIndex, middleIndex-1);
    }
}