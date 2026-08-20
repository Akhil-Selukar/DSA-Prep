package org.akhil;

public class Solution {
    // O(N)/O(N)
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int p1 = 0;
        int p2 = 0;

        for(int i=0; i<n; i++){
            if(i==0){
                arr1[p1++] = nums[i];
            } else if(i==1){
                arr2[p2++] = nums[i];
            } else {
                if(arr1[p1-1] > arr2[p2-1]){
                    arr1[p1++] = nums[i];
                } else {
                    arr2[p2++] = nums[i];
                }
            }
        }

        for(int i=0; i<p2; i++){
            arr1[p1++] = arr2[i];
        }

        return arr1;
    }
}
