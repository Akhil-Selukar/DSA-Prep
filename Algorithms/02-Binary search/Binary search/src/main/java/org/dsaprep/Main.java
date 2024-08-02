package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,9,12,13,16,18,19};
        int[] arr2 = {19,18,16,13,12,9,7,6,5,3,1};
        int target = 5;

        System.out.println(binarySearchAscending(arr, target));
        System.out.println(binarySearchDescending(arr2, target));
        System.out.println(binarySearchOrderAgnostic(arr, target));
        System.out.println(binarySearchOrderAgnostic(arr2, target));
    }

    // ################### Binary search for array sorted in ascending order ####################
    public static int binarySearchAscending(int[] arr, int target){
        int startIndex = 0;
        int endIndex = arr.length-1;

        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex-startIndex)/2;
            if(target == arr[midIndex]){
                return midIndex;
            } else if(target < arr[midIndex]){
                endIndex = midIndex-1;
            } else {
                startIndex = midIndex+1;
            }
        }
        return -1;
    }

    // ################### Binary search for array sorted in descending order ####################
    public static int binarySearchDescending(int[] arr, int target){
        int startIndex = 0;
        int endIndex = arr.length-1;

        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex-startIndex)/2;
            if(target == arr[midIndex]){
                return midIndex;
            } else if(target < arr[midIndex]){
                startIndex = midIndex+1;
            } else {
                endIndex = midIndex-1;
            }
        }
        return -1;
    }


//    ################### Order agnostic binary search #####################
    public static int binarySearchOrderAgnostic(int[] arr, int target){
        int startIndex = 0;
        int endIndex = arr.length-1;

        if(arr[startIndex]-arr[endIndex]>0){
            while(startIndex <= endIndex){
                int midIndex = startIndex + (endIndex-startIndex)/2;
                if(target == arr[midIndex]){
                    return midIndex;
                } else if(target < arr[midIndex]){
                    startIndex = midIndex+1;
                } else {
                    endIndex = midIndex-1;
                }
            }
        } else {
            while(startIndex <= endIndex){
                int midIndex = startIndex + (endIndex-startIndex)/2;
                if(target == arr[midIndex]){
                    return midIndex;
                } else if(target < arr[midIndex]){
                    endIndex = midIndex-1;
                } else {
                    startIndex = midIndex+1;
                }
            }
        }
        return -1;
    }
}