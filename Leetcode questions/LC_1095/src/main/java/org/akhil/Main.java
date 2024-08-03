package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,8,7,5,};
        int target = 8;

        System.out.println(findInMountainArray(arr, target));
    }

    public static int findInMountainArray(int[] arr, int target){
        int peakIndex = findPeakIndex(arr);

        int index = searchInRange(arr, target, 0, peakIndex);
        if(index == -1){
            index = searchInRange(arr, target, peakIndex, arr.length-1);
        }
        return index;
    }

    private static int findPeakIndex(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length-1;

        while(startIndex<endIndex){
            int midIndex = startIndex + (endIndex-startIndex)/2;

            if(arr[midIndex]>arr[midIndex+1]){
                endIndex = midIndex;
            } else {
                startIndex = midIndex+1;
            }
        }
        return startIndex;
    }

    private static int searchInRange(int[] arr, int target, int startIndex, int endIndex){

        boolean isAscending = arr[startIndex]-arr[endIndex]<0;

        while(startIndex<=endIndex){
            int midIndex = startIndex + (endIndex-startIndex)/2;

            if(target<arr[midIndex]){
                if(isAscending)
                    endIndex = midIndex-1;
                else
                    startIndex = midIndex+1;
            } else if(target>arr[midIndex]){
                if(isAscending)
                    startIndex = midIndex+1;
                else
                    endIndex = midIndex-1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }
}