package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,8,9,12,16,19,23,25};
        int target = 8;

        System.out.println(fineTarget(arr, target));
    }

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
}