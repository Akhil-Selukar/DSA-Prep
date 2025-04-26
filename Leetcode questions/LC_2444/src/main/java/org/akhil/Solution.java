package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Bruteforce (O(N^2)/O(1)) will give TLE
//    public long countSubarrays(int[] nums, int minK, int maxK) {
//        long count = 0;
//
//        for(int i=0; i<nums.length; i++){
//            for(int j=i; j<nums.length; j++){
//                if(isValid(Arrays.copyOfRange(nums, i, j+1), minK, maxK)){
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
//
//    private boolean isValid(int[] nums, int mink, int maxk){
//        int min = Arrays.stream(nums).min().getAsInt();
//        int max = Arrays.stream(nums).max().getAsInt();
//
//        if(min == mink && max == maxk){
//            return true;
//        }
//
//        return false;
//    }


    // Solution 1.1 - bruteforce (O(N^2)/O(1)) will give TLE.
//    public long countSubarrays(int[] nums, int minK, int maxK) {
//        long count = 0;
//
//        for(int i=0; i<nums.length; i++){
//            for(int j=i; j<nums.length; j++){
//                if(isValid(nums, i, j, minK, maxK)){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    private boolean isValid(int[] nums, int i, int j, int mink, int maxk){
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for(int start = i; start<=j; start++){
//            int num = nums[start];
//            if(num > max){
//                max = num;
//            }
//            if(num < min){
//                min = num;
//            }
//        }
//
//        if(min == mink && max == maxk){
//            return true;
//        }
//        return false;
//    }


    // Solution 2 - Optimized (O(N)/O(1)) using sliding window.
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int minIndex = -1;
        int maxIndex = -1;
        int violationIndex = -1;

        for(int i=0; i<nums.length; i++){
            int num = nums[i];

            if(num == minK){
                minIndex = i;
            }
            if(num == maxK){
                maxIndex = i;
            }
            if((num > maxK) || (num < minK)){
                violationIndex = i;
            }

            if(minIndex >= 0 && maxIndex >= 0){
                int possibleArrays = Math.min(minIndex, maxIndex) - violationIndex;

                if(possibleArrays > 0){
                    count = count + possibleArrays;
                }
            }
        }

        return count;
    }
}
