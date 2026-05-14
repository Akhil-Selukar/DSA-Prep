package org.akhil;

import java.util.Arrays;

public class Solution {
    // // Solution 1 - Using count sort
    // // O(MaxVal)/O(MaxVal)
    // public boolean isGood(int[] nums) {
    //     int n = nums.length;
    //     int maxVal = Arrays.stream(nums).max().getAsInt();
    //     int[] count = new int[maxVal+1];

    //     for(int num:nums){
    //         count[num]++;
    //     }

    //     for(int i=1; i<=maxVal; i++){
    //         if(i != maxVal && count[i] != 1){
    //             return false;
    //         } else if(i == maxVal && count[i] != 2){
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    // ---------------------
    // Solution 2 - Using sorting
    // O(NlogN)/O(1)
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            if(i != n-1 && nums[i] != i+1){
                return false;
            } else if(i == n-1 && nums[i] != i){
                return false;
            }
        }
        return true;
    }
}
