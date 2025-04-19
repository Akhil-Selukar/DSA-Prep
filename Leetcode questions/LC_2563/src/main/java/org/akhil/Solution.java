package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution - 1 BruteForce (O(N^2)/O(1)) TLE
//    public long countFairPairs(int[] nums, int lower, int upper) {
//        int count = 0;
//        for(int i=0; i<nums.length; i++){
//            for(int j=i+1; j<nums.length; j++){
//                int addition = nums[i]+nums[j];
//                if(lower <= addition && addition <= upper){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // Solution - 2 using binary search and Maths O(NLog(N)/O(1))
    public long countFairPairs(int[] nums, int lower, int upper) {

        int count = 0;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-1; i++){
            int newLow = lower - nums[i];
            int newHigh = upper - nums[i];

            int lowerBound = lowerBound(nums, i+1, nums.length, newLow);
            int upperBound = upperBound(nums, i+1, nums.length, newHigh);

            count = count + (upperBound - lowerBound);
        }
        return count;
    }

    private int upperBound(int[] nums, int startIndex, int endIndex, int target) {
        while(startIndex < endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(nums[midIndex] <= target){
                startIndex = midIndex+1;
            } else {
                endIndex = midIndex;
            }
        }
        return startIndex;
    }

    private int lowerBound(int[] nums, int startIndex, int endIndex, int target) {
        while(startIndex < endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(nums[midIndex] < target){
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex;
            }
        }
        return startIndex;
    }
}
