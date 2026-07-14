package org.akhil;

import java.util.Arrays;

public class Solution {

    final int MOD = (int)(1e9+7);
    public int subsequencePairCount(int[] nums) {
        int max = 0;
        int n = nums.length;
        for(int val:nums){
            max = Math.max(val, max);
        }

        int[][][] dp = new int[n][max+1][max+1];

        for(int[][] mat:dp){
            for(int[] row:mat){
                Arrays.fill(row, -1);
            }
        }

        return helper(0, nums, 0, 0, dp);     // both gcds are 0 because gcd of any number with 0 is mod(num)
    }

    private int helper(int index, int[] nums, int gcd1, int gcd2, int[][][] dp){
        // base case
        if(index == nums.length ){
            if((gcd1 != gcd2) || (gcd1 == 0 && gcd2 == 0)){
                return 0;
            } else {
                return 1;
            }
        }

        if(dp[index][gcd1][gcd2] != -1){
            return dp[index][gcd1][gcd2];
        }

        // option 1 - add nums[index] in sequence 1
        long option1 = helper(index+1, nums, gcd(gcd1, nums[index]), gcd2, dp);
        // option 2 - add nums[index] in sequence 2
        long option2 = helper(index+1, nums, gcd1, gcd(gcd2, nums[index]), dp);
        // option 3 - Skip nums[index]
        long option3 = helper(index+1, nums, gcd1, gcd2, dp);

        long ans = (option1%MOD + option2%MOD + option3%MOD)%MOD;
        dp[index][gcd1][gcd2] = (int)ans;
        return (int)ans;
    }

    private int gcd(int num1, int num2){
        if(num2 == 0){
            return num1;
        }

        return gcd(num2, num1%num2);
    }
}
