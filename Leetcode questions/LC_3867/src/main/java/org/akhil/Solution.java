package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(NlogN)/O(N)
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int maxVal = -1;
        int[] prefixGCD = new int[n];

        for(int i=0; i<n; i++){
            maxVal = Math.max(maxVal, nums[i]);
            prefixGCD[i] = gcd(nums[i], maxVal);
        }

        Arrays.sort(prefixGCD);

        long result = 0;
        int start = 0;
        int end = n-1;

        while(start < end){
            result = result + gcd(prefixGCD[start], prefixGCD[end]);
            start++;
            end--;
        }

        return result;
    }

    private int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
}
