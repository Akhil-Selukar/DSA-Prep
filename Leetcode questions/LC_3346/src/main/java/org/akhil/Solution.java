package org.akhil;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxElement = 0;
        for(int num:nums){
            maxElement = Math.max(maxElement, num);
        }

        int[] count = new int[maxElement+1];

        for(int num:nums){
            count[num]++;
        }

        int[] prefixSum = new int[maxElement+1];
        prefixSum[0] = count[0];

        for(int i=1; i<maxElement+1; i++){
            prefixSum[i] = count[i] + prefixSum[i-1];
        }

        int result = 0;
        for(int i=0; i<prefixSum.length; i++){
            int leftBoundary = Math.max(0, i-k);
            int rightBoundary = Math.min(prefixSum.length-1, i+k);

            int totalPossible = prefixSum[rightBoundary] - (leftBoundary > 0 ? prefixSum[leftBoundary-1]:0);
            int needToConvert = totalPossible - count[i];      // we are checking for i and it i is already there then no need to subtract and add 0 in it to convert it again into i (it will just consume operations)
            int canConvert = Math.min(numOperations, needToConvert);      // we only have numOfOperations allowed hence if needToConvert is more than that then we can't perform that many conversions
            result = Math.max(result, canConvert + count[i]);       // total we can convert + if we already have i values that we don't need to convert
        }

        return result;
    }
}
