package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 12, 13, 15, 1, 2, 3};  // this is a rotated sorted array.
        int target = 1;

        System.out.println(rbSearch(arr, target, 0, arr.length-1));
    }

    protected static int rbSearch(int[] arr, int target, int startIndex, int endIndex) {
        if(startIndex > endIndex){
            return -1;
        }

        int midIndex = startIndex + (endIndex - startIndex)/2;
        if(target == arr[midIndex]){
            return midIndex;
        }
        // check first half of the array (i.e. start till mid) if it is sorted then we can apply normal Binary search
        if(arr[startIndex] <= arr[midIndex]){ // means this part is normally sorted
            if(arr[startIndex]<=target && target <= arr[midIndex]){
                return rbSearch(arr, target, startIndex, midIndex-1);
            } else {
                return rbSearch(arr, target, midIndex+1, endIndex);
            }
        }
        if(arr[startIndex]<= target && target>= arr[midIndex]){
            return rbSearch(arr, target, startIndex, midIndex-1);
        } else {
            return rbSearch(arr, target, midIndex+1, endIndex);
        }
    }
}