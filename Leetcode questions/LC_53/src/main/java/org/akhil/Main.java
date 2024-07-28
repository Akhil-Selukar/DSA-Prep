package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sum > maxSum){
                maxSum = sum;
            }

            if(sum < 0){    // This is because if at any point our sum is negative, then instead of holding that sum and sub array, we can start new subarray from current index as first index in subarray and the initial sum as 0 (0 will always greater than negative sum so sum of this new subarray will always be greater than the previous one.)
                sum = 0;
            }
        }
        return maxSum;
    }
}