package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - bruteforce (O(N^2)/O(N)) - Not an optimized solution
//    public int countCompleteSubarrays(int[] nums) {
//        int uniqueCount = (int) Arrays.stream(nums).distinct().count();
//        int count = 0;
//
//        // form subarrays and count distinct elements in subarray.
//        for(int i=0; i<nums.length; i++){
//            Set<Integer> set = new HashSet<>();
//            for(int j=i; j<nums.length; j++){
//                set.add(nums[j]);
//                // check if this subarray from i to j is complete or not
//                if(uniqueCount == set.size()){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // Solution 2 - O(N)/O(N)
    public int countCompleteSubarrays(int[] nums) {
//        int uniqueCount = (int) Arrays.stream(nums).distinct().count();       // dont use stream API's unless asked it is slower than normally using set.

        // calculate number of unique elements
        Set<Integer> unique = new HashSet<>();
        for(int num:nums){
            unique.add(num);
        }
        int uniqueCount = unique.size();

        // Initialize window of size 1 (0th indexed element).
        int start = 0;
        int end = 0;
        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        // expand the window till be get complete subarray
        while(start < n){
            freq.put(nums[end], freq.getOrDefault(nums[end], 0)+1);

            while(uniqueCount == freq.size()){      // found the complete subarray
                count = count + (n-end);

                freq.put(nums[start], freq.get(nums[start])-1);
                if(freq.get(nums[start]) == 0){
                    freq.remove(nums[start]);
                }
                start++;
            }

            end++;
            if(end>=n){
                break;
            }
        }

        return count;
    }
}
