package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0,1,2,5,6,8,7,6,4,3,1};

        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length-1;

        while(startIndex<endIndex){         // not equal to because here both start and end index are trying to reach to the index of peak, So when they are equal it will be the peak and we don't want to modify them further.
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(arr[midIndex]>arr[midIndex+1]){
                endIndex = midIndex;
            } else {
                startIndex = midIndex+1;
            }
        }
        return startIndex;
    }
}