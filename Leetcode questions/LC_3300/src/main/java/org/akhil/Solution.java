package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;

        for(int num:nums){
            minSum = Math.min(minSum, getDigitSum(num));
        }

        return minSum;
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
