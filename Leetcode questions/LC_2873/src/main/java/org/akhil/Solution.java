package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - Bruteforce (O(N^3)/O(1))
//    public long maximumTripletValue(int[] nums) {
//        long maxValue = 0;
//        int n =nums.length;
//
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<n; j++){
//                for(int k=j+1; k<n; k++){
//                    maxValue = Math.max(maxValue, (long)(nums[i]-nums[j])*nums[k]);
//                }
//            }
//        }
//        return maxValue;
//    }


    // Solution 2 - precomputing k value (i.e. rightMax) (O(N^2)/O(N))
    // Here to get ((nums[i]-nums[j])*nums[k]) as max we need to maximize nums[i] and nums[k] while minimizing nums[j].
    // (while doing this we need to ensure i<j<k is satisfied.) Hence we can precompute k value and store in a map to fetch in constant time complexity
    // this will reduce 1 nested loop and the time complexity will be reduced to O(N^2) while we need a map to store max value to the right of each index
    // hence space complexity will increase to O(N)
//    public long maximumTripletValue(int[] nums) {
//        long maxValue = 0;
//        int n =nums.length;
//        Map<Integer, Integer> rightMax = new HashMap<>();
//
//        int max = nums[n-1];
//        for(int k=n-2; k>=0; k--){
//            rightMax.put(k, max);
//            max = Math.max(max, nums[k]);
//        }
//
//        for(int i=0; i<n-2; i++){
//            for(int j=i+1; j<n-1; j++){
//                maxValue = Math.max(maxValue, (long)(nums[i]-nums[j])*rightMax.get(j));
//            }
//        }
//        return maxValue;
//    }

    // Solution 3 - O(N)/O(1)
    public long maximumTripletValue(int[] nums) {
        long maxValue = 0;
        int n =nums.length;

        long leftDiffMax = 0;    // to track max of (nums[i]-nums[j]) difference.
        long maxLeftVal = 0;     // to track max value at left i.e. nums[i] value

        for(int i=0; i<n; i++){
            maxValue = (long)Math.max(maxValue, (long)(leftDiffMax*nums[i]));   //here i is considered as z
            leftDiffMax = (long)Math.max(leftDiffMax, maxLeftVal-nums[i]);         // here i acts as j to calculate max(nums[i]-nums[j])
            maxLeftVal = (long)Math.max(maxLeftVal, nums[i]);
        }

        return maxValue;
    }
}
