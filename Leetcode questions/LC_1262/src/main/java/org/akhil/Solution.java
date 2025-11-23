package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    // Solution 1 - Normal recursion bruteforce
    // O(2^N)/O(N) -> TLE
    // public int maxSumDivThree(int[] nums) {
    //     return helper(nums, 0, 0);
    // }

    // private int helper(int[] nums, int index, int remainder){
    //     if(index >= nums.length){
    //         return (remainder == 0) ? 0 : Integer.MIN_VALUE;
    //     }

    //     // take
    //     int take = nums[index] + helper(nums, index+1, (remainder + nums[index])%3);

    //     // notTake
    //     int notTake = helper(nums, index+1, remainder);

    //     return Math.max(take, notTake);
    // }


    // -------------------------
    // Solution 2 - Using memoization
    // O(N)/O(N)
    // public int maxSumDivThree(int[] nums) {
    //     int[][] dp = new int[nums.length][3];
    //     for(int[] row:dp){
    //         Arrays.fill(row, -1);
    //     }

    //     return helper(nums, 0, 0, dp);
    // }

    // private int helper(int[] nums, int index, int remainder, int[][] dp){
    //     if(index >= nums.length){
    //         return (remainder == 0) ? 0 : Integer.MIN_VALUE;
    //     }

    //     if(dp[index][remainder] != -1){
    //         return dp[index][remainder];
    //     }
    //     // take
    //     int take = nums[index] + helper(nums, index+1, (remainder + nums[index])%3, dp);

    //     // notTake
    //     int notTake = helper(nums, index+1, remainder, dp);

    //     return dp[index][remainder] = Math.max(take, notTake);
    // }


    // --------------------
    // More easy to understant and intuitive solution
    // The important part to observe here is in case of dividing by 3 we can only get 1 or 2 as remainders (considering we are not worried about 0 as remainder)
    // So we can find out the single/combinations of element which are adding that extra 1 or 2 (we got as remainder) and remove them form the total sum.
    // Solution 2 - using some maths.
    // O(N)/O(N)
    public int maxSumDivThree(int[] nums) {
        List<Integer> oneRemainder = new ArrayList<>();
        List<Integer> twoRemainder = new ArrayList<>();
        int totalSum = 0;

        for(int num:nums){
            if(num%3 == 1){
                oneRemainder.add(num);
            }
            if(num%3 == 2){
                twoRemainder.add(num);
            }

            totalSum = totalSum+num;
        }

        Collections.sort(oneRemainder, (a, b)->{
            return a-b;
        });
        Collections.sort(twoRemainder, (a, b)->{
            return a-b;
        });

        int remainder = totalSum % 3;

        if(remainder == 0){
            return totalSum;
        } else if(remainder == 1){
            int option1 = Integer.MAX_VALUE;
            int option2 = Integer.MAX_VALUE;

            if(oneRemainder.size() != 0){
                option1 = oneRemainder.get(0);
            }
            if(twoRemainder.size() >= 2){
                option2 = twoRemainder.get(0) + twoRemainder.get(1);
            }

            return totalSum - Math.min(option1, option2);
        } else {
            int option1 = Integer.MAX_VALUE;
            int option2 = Integer.MAX_VALUE;

            if(oneRemainder.size() >= 2){
                option1 = oneRemainder.get(0) + oneRemainder.get(1);
            }
            if(twoRemainder.size() != 0){
                option2 = twoRemainder.get(0);
            }

            return totalSum - Math.min(option1, option2);
        }
    }
}
