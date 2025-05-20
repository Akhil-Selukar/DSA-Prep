package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - O(Q*N)/O(1) where Q is number of queries and N is number of elements in nums array.
//    public boolean isZeroArray(int[] nums, int[][] queries) {
//
//        for(int[] query:queries){
//            int start = query[0];
//            int end = query[1];
//
//            for(int i=start; i<=end; i++){
//                if(nums[i]>0){
//                    nums[i]--;
//                }
//            }
//        }
//
//        for(int i=0; i<nums.length; i++){
//            if(nums[i] > 0){
//                return false;
//            }
//        }
//
//        return true;
//    }


    // Solution 2 - Using Difference array
    // O(N+Q)/O(N)
    public boolean isZeroArray(int[] nums, int[][] queries) {

        int[] diff = new int[nums.length];

        for (int[] query : queries) {       // O(Q)
            int start = query[0];
            int end = query[1];

            diff[start]++;
            if((end + 1) < nums.length) {
                diff[end + 1]--;      // end+1 because end is inclusive (i.e. we have to decrement element at end as well by 1)
            }
        }

        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {         // O(N)
            runningSum += diff[i];
            nums[i] = nums[i] - runningSum;

            if (nums[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
