package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - O(N)/O(1)
//    public int maximumCount(int[] nums) {
//        int positive = 0;
//        int negative = 0;
//
//        for(int num:nums){
//            if(num<0){
//                negative++;
//            }
//            if(num>0){
//                positive++;
//            }
//        }
//
//        return Math.max(positive, negative);
//    }


    // Solution 2 - O(N)/O(1)   Even though this solution is short and simple and has same space and time complexity still the first one is better and fast.
//    public int maximumCount(int[] nums) {
//        return (int) Math.max(Arrays.stream(nums).filter(num -> num < 0).count(),
//                Arrays.stream(nums).filter(num -> num > 0).count());
//    }


    // Solution 3 - O(lon(N))/O(1)  for normal length of array this reduced complexity will not make much of a difference rather here we are using more int variables that the first approach hence more space will be consumed.
    // real difference will be there in case the array is huge.
    public int maximumCount(int[] nums) {
        int negCount = binarySearch(nums, 0);
        int posCount = nums.length - binarySearch(nums, 1);
        return Math.max(negCount, posCount);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }
}
