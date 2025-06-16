package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - bruteforce  (TLE)
    // O(N^2)/O(1)
//    public int maxRotateFunction(int[] nums) {
//        int n = nums.length;
//        int max = Integer.MIN_VALUE;
//
//        for(int i=0; i<n; i++){
//            int sum = 0;
//            for(int j=0; j<n; j++){
//                int index = (j+i)%n;
//                sum = sum + (j * nums[index]);
//            }
//            max = Math.max(max, sum);
//        }
//        return max;
//    }


    // Solution 2 - Optimized O(N)/O(1) Solution
    // Here if we observe carefully then while rotating every time we are adding sum of array and to the previous F() answer and subtracting last element times N where N is number of elements in array.
    // F(i) = F(i-1) + sum(nums) - (n * arrk[nums.length-1])

//    public int maxRotateFunction(int[] nums) {
//        int n = nums.length;
//        int max = Integer.MIN_VALUE;
//        int sum = Arrays.stream(nums).sum();
//        int functionVal = 0;
//
//        for(int i=0; i<n; i++){
//            functionVal = functionVal + (i * nums[i]);
//        }
//
//        for(int i=n-1; i>=0; i--){
//            functionVal = functionVal + sum - (n * nums[i]);
//            max = Math.max(max, functionVal);
//        }
//
//        return max;
//    }

    // Solution 2.1 - Minor changes to make faster (complexities are still same)
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int functionVal = 0;

        for(int i=0; i<n; i++){
            sum = sum + nums[i];
            functionVal = functionVal + (i * nums[i]);
        }

        for(int i=n-1; i>=0; i--){
            functionVal = functionVal + sum - (n * nums[i]);
            max = Math.max(max, functionVal);
        }

        return max;
    }
}
