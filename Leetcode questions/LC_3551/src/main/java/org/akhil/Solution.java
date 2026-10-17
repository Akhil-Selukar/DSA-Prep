package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // first sort the copy of array as per given rules (why copy and not original is explained below)
    // then compare elements in original array and sorted array and if they are different then perfor the swapping in original
    // array. By this way we will be able to cout the actual swap required.
    // If the question says return the sorted array then we can simply sort the original array itself and return it.

    // O(NlogN * N)/O(N)
    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] sorted = new Integer[n];

        for(int i=0; i<n; i++){
            sorted[i] = nums[i];
        }

        Arrays.sort(sorted, (a, b)->{
            int digitSumA = getDigitSum(a);
            int digitSumB = getDigitSum(b);

            if(digitSumA == digitSumB){
                return a - b;
            }
            return digitSumA - digitSumB;
        });

        // we need index of expected val in original array hence we need to create val against index map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i], i);
        }

        int result = 0;
        for(int i=0; i<n; i++){
            int expectedVal = sorted[i];
            int currVal = nums[i];

            if(expectedVal == currVal){
                continue;
            }

            int indexInOriginal = map.get(expectedVal);

            nums[i] = expectedVal;
            nums[indexInOriginal] = currVal;

            map.put(expectedVal, i);
            map.put(currVal, indexInOriginal);

            result++;
        }

        return result;
    }


    private int getDigitSum(int num){
        int sum = 0;

        while(num > 0){
            sum = sum + num%10;
            num = num/10;
        }
        return sum;
    }
}
