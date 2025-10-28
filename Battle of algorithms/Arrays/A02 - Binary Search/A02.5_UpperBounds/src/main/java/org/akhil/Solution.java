package org.akhil;

public class Solution {

    // Returns the index of next greater element to the target.
    // if no such element is present then return length of the array (i.e. OOB index)
    public int upperBounds(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int start = 0;
        int end = arr.length;
        int result = end;

        while(start < end){
            int mid = start + (end-start)/2;

            if(arr[mid] <= target){
                start = mid+1;
            } else {
                result = mid;
                end = mid;
            }
        }

        return result;
    }
}
