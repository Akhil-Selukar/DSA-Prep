package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(N)/O(N)
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = 0;
        int currSum = 0;
        int[] bestMinLenTill = new int[n];

        Arrays.fill(bestMinLenTill, Integer.MAX_VALUE);
        int bestMinLength = Integer.MAX_VALUE;      // this will hold overall minimum length of sub array with sum == target so that we can make overall sum smallest
        int result = Integer.MAX_VALUE;

        while(end < n){ // sliding window till end goes OOB
            currSum = currSum + arr[end];

            // if currSum exceed target
            while(start<end && currSum > target){
                currSum = currSum - arr[start];
                start++;
            }

            // if we found the sub array with sum == target
            if(currSum == target){
                int length = end-start + 1;     // length of curr sub array

                if(start>0 && bestMinLenTill[start-1] != Integer.MAX_VALUE){
                    result = Math.min(result, length + bestMinLenTill[start-1]);
                }
                bestMinLength = Math.min(bestMinLength, length);    // if current length is smallest then update bestMinLength
            }
            bestMinLenTill[end] = bestMinLength;
            end++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
