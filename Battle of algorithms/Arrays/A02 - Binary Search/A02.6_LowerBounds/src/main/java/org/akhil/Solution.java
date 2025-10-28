package org.akhil;

public class Solution {
    // Returns the index of last smaller element to the target.
    // if no such element is present then return -1 (i.e. OOB index)
    public int lowerBounds(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int start = 0;
        int end = arr.length;
        int result = end;

        while(start < end){
            int mid = start + (end-start)/2;

            if(arr[mid] < target){
                start = mid+1;
            } else {
                end = mid;
                result = mid;
            }
        }

        return result;
    }
}
