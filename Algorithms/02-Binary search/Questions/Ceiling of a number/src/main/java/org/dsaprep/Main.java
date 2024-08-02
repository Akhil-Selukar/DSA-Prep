package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,8,9,12,16,19};
        int[] arr2 = {19,16,12,9,8,6,3,2,1};
        int target = 7;

        System.out.println(ceilingNumber(arr, target));
        System.out.println(ceilingNumber(arr2, target));
    }

    public static int ceilingNumber(int[] arr, int target){
        int startIndex = 0;
        int endIndex = arr.length-1;

        if(arr[startIndex] - arr[endIndex]>0){
            while(startIndex<=endIndex){
                int midIndex = startIndex + (endIndex - startIndex)/2;
                if(target == arr[midIndex]){
                    return midIndex;
                } else if(target<arr[midIndex]){
                    startIndex = midIndex+1;
                } else {
                    endIndex = midIndex-1;
                }
            }
            return endIndex;
        } else {
            while(startIndex<=endIndex){
                int midIndex = startIndex + (endIndex - startIndex)/2;
                if(target == arr[midIndex]){
                    return midIndex;
                } else if(target<arr[midIndex]){
                    endIndex = midIndex-1;
                } else {
                    startIndex = midIndex+1;
                }
            }
            return startIndex;
        }
    }
}