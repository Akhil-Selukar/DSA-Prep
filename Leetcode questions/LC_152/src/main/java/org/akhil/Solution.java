package org.akhil;

public class Solution {
    public int maxProduct(int[] nums) {
//        int max = Arrays.stream(nums).max();

        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max, num);
        }

        int currentMax = 1;
        int currentMin = 1;

        for(int num:nums){
            int temp = currentMax * num;

            currentMax = Math.max(temp, Math.max(currentMin * num, num));
            currentMin = Math.min(temp, Math.min(currentMin * num, num));

            max = Math.max(currentMax, max);
        }

        return max;
    }
}
