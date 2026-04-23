package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // Solution 1 - Bruteforce
    // O(N^2)/O(N)
    // TLE for last 3 Test cases
//    public long[] distance(int[] nums) {
//        int n = nums.length;
//        Map<Integer, List<Integer>> map = new HashMap<>();
//
//        for(int i=0; i<n; i++){
//            if(!map.containsKey(nums[i])){
//                map.put(nums[i], new ArrayList<>());
//            }
//            map.get(nums[i]).add(i);
//        }
//
//        long[] result = new long[n];
//
//        for(int i=0; i<n; i++){
//            if(map.get(nums[i]).size() > 1){
//                List<Integer> indices = map.get(nums[i]);
//                long sum = 0;
//                for(int index:indices){
//                    sum = sum + Math.abs(i-index);
//                }
//                result[i] = sum;
//            }
//        }
//
//        return result;
//    }

    // --------------------
    // Solution 2 - using prefixSum
    // O(N)/O(N)
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        long[] result = new long[n];

        // here instead of iteration over entire indices and calculating sum we are doing some precomputation
        for(List<Integer> indices:map.values()){
            int size = indices.size();

            long leftSum = 0;
            long totalSum = 0;

            for(int i=0; i<size; i++) {
                totalSum = totalSum + indices.get(i);
            }

            // now use total sum and calculate left and right sum of the indices
            // for all indices left to curr index it will be k*indices.get(k) - leftSum where k is the kth number of index and leftSum is sum of all indices to kth index

            for(int i=0; i<size; i++){
                totalSum = totalSum - indices.get(i);   // exclude current index value from total sum because i-i will give 0

                long currSum = 0;

                // for left side, ith value will have i values to the left
                currSum = currSum + ((long) i*indices.get(i) - leftSum);

                // for right side
                currSum = currSum + (totalSum - (long) (size - i - 1) *indices.get(i));

                leftSum = leftSum + indices.get(i);

                result[indices.get(i)] = currSum;
            }
        }
        return result;
    }
}
