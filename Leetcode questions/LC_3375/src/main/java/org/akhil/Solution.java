package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - using frequency map
    // O(N)/O(N) - This is also valid solution but use map in case range of nums[i] is huge.
    // Here range is 1 <= nums[i] <= 100 which means max to max 100 distinct values can be there in nums hence it is good to use frequency array.
//    public int minOperations(int[] nums, int k) {
//        int count = 0;
//        int min = Integer.MAX_VALUE;
//        Map<Integer, Integer> freq = new HashMap<>();
//
//        for (int num : nums) {
//            min = Math.min(min, num);
//            if (min < k) {
//                return -1;
//            }
//
//            int numFreq = freq.getOrDefault(num, 0);
//            freq.put(num, numFreq + 1);
//            if ((num > k) && (numFreq == 0)) {
//                count++;
//            }
//        }
//
//        return count;
//    }

    // Solution 2 - Using frequency array
    // O(N)/O(1)
    public int minOperations(int[] nums, int k) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        int[] freq = new int[101];

        for (int num : nums) {
            min = Math.min(min, num);
            if (min < k) {
                return -1;
            }

            int numFreq = freq[num];
            freq[num] = numFreq + 1;
            if ((num > k) && (numFreq == 0)) {
                count++;
            }
        }

        return count;
    }
}
