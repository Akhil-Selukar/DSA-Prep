package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - bruteforce  (TLE)
    // O(N^2)/O(N)
//    public int[] smallestSubarrays(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//
//        for(int i=0; i<n; i++){
//            res[i] = helper(nums, i);
//        }
//
//        return res;
//    }
//
//    private int helper(int[] nums, int start){
//        int maxOR = 0;
//
//        for(int i=start; i<nums.length; i++){
//            maxOR = maxOR | nums[i];
//        }
//
//        int currOR = 0;
//        for(int j = start; j<nums.length; j++){
//            currOR = currOR | nums[j];
//            if(currOR == maxOR){
//                return (j-start+1);
//            }
//        }
//        return nums.length-start;
//    }


    // Solution 2 - ensuring each bit is set
    // O(N)/O(N)
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] setBitIndex = new int[31];
        Arrays.fill(setBitIndex, -1);

        for (int i = n - 1; i >= 0; i--) {
            int endIndex = i;
            for (int j = 0; j < 31; j++) {
                if ((nums[i] & (1 << j)) == 0) {
                    if (setBitIndex[j] != -1) {
                        endIndex = Math.max(endIndex, setBitIndex[j]);
                    }
                } else {
                    setBitIndex[j] = i;
                }
            }
            result[i] = endIndex - i + 1;
        }

        return result;
    }
}
