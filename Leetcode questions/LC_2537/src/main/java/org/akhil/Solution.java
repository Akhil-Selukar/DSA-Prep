package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - BruteForce (O(N^2)/O(N)) will give TLE
//    public long countGood(int[] nums, int k) {
//        long goodPairs = 0;
//
//        for(int i=0; i<nums.length; i++){
//            Map<Integer, Integer> freq = new HashMap<>();
//            int pairCount = 0;      // pair count in current subArray
//            for(int j=i; j<nums.length; j++){
//                pairCount = pairCount + freq.getOrDefault(nums[j], 0);
//                freq.put(nums[j], freq.getOrDefault(nums[j], 0)+1);
//
//                if(pairCount >= k){
//                    goodPairs++;
//                }
//            }
//        }
//
//        return goodPairs;
//    }

    // Solution 2 - Sliding window (O(N)/O(N))
    public long countGood(int[] nums, int k) {
        long goodPairs = 0;
        long currPairs = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        while(left < n){
            if(right < n && currPairs < k){
                map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
                int freq = map.get(nums[right]);
                if(freq > 1) {
                    currPairs = currPairs + (freq - 1);
                }
                right++;
            }

            if(currPairs >= k){
                goodPairs = goodPairs + (n - right + 1);
                int leftVal = nums[left];
                left++;
                map.put(leftVal, map.get(leftVal)-1);

                if(map.get(leftVal) >= 1){           // >=1 means earlier it was at least 2 which means it was contributing to the Current pairs.
                    currPairs = currPairs - map.get(leftVal);
                }
            }

            if(right >= n && currPairs < k){
                break;
            }
        }

        return goodPairs;
    }
}
