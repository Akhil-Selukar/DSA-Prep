package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,8,9,12,16,19,23,25};
        int target = 8;

        System.out.println(fineTarget(arr, target));
    }

    // Searching in range continuously.
    public static int fineTarget(int[] arr, int target){
        int startIndex = 0;
        int endIndex = 1;

        while(startIndex<=endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(target<arr[midIndex]){
                endIndex = midIndex-1;
            } else if (target>arr[midIndex]){
                int temp = startIndex;
                startIndex = midIndex+1;
                endIndex = startIndex + (2*(endIndex-temp));
            } else {
                return midIndex;
            }
        }
        return -1;
    }

// More optimized code.
// First finding the range and then searching in only that range.
    public static int fineTarget2(int[] arr, int target){
        int startIndex = 0;
        int endIndex = 1;

        while(target>arr[endIndex]){
            int temp = endIndex+1;
            endIndex = temp + (endIndex - startIndex + 1);
            startIndex = temp;
        }

        return search(arr, target, startIndex, endIndex);
    }

    public static int search(int[] arr, int target, int start, int end){
        int startIndex = start;
        int endIndex = end;

        while(startIndex<=endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(target<arr[midIndex]){
                endIndex = midIndex-1;
            } else if (target>arr[midIndex]){
                startIndex = midIndex+1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }
}