package org.akhil;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    // This question is exactly same as that of LC-3346 but the constraints are very high here.
    // So same logic will give memory/time limit exceeded
    // Solution - Same logic of difference array but instead of storing entire array we just store critical points where frequency count can change.
    // O(NlogN)/O(N)
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxVal = 0;
        for(int num:nums){
            maxVal = Math.max(maxVal, num);
        }

        TreeMap<Integer, Integer> diff = new TreeMap<>();       // to store difference array
        HashMap<Integer, Integer> freq = new HashMap<>();       // to store frequency

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            int leftBoundary = Math.max(num - k, 0);
            int rightBoundary = Math.min(num + k, maxVal);

            diff.put(leftBoundary, diff.getOrDefault(leftBoundary, 0) + 1);
            diff.put(rightBoundary + 1, diff.getOrDefault(rightBoundary + 1, 0) - 1);

            diff.putIfAbsent(num, diff.getOrDefault(num, 0));
        }

        int result = 1;
        int cumSum = 0;

        // O(n)
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            int target = entry.getKey();
            int value = entry.getValue();

            cumSum = cumSum + value;
            int targetFreq = freq.getOrDefault(target, 0);
            int conversionNeeded = cumSum - targetFreq;

            int maxPossibleFreq = Math.min(conversionNeeded, numOperations);
            result = Math.max(result, targetFreq + maxPossibleFreq);
        }

        return result;
    }
}
