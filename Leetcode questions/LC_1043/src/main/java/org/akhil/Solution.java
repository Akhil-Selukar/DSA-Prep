package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Normal recursion

//    public int maxSumAfterPartitioning(int[] arr, int k) {
//        int n = arr.length;
//
//        return helper(arr, 0, n, k);
//    }
//
//    private int helper(int[] arr, int startIndex, int endIndex, int k) {
//        if(startIndex == arr.length){
//            return 0;
//        }
//        int length = 0;
//        int maxInPartition = Integer.MIN_VALUE;
//        int maxAnswer = Integer.MIN_VALUE;
//
//        for(int i=startIndex; i < Math.min(startIndex+k, endIndex); i++){
//            length++;
//            maxInPartition = Math.max(maxInPartition, arr[i]);
//            int ansInPartition = length * maxInPartition + helper(arr, i+1, endIndex, k);
//
//            maxAnswer = Math.max(maxAnswer, ansInPartition);
//        }
//        return maxAnswer;
//    }

    // Solution 2 - Memoization

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(arr, 0, n, k, dp);
    }

    private int helper(int[] arr, int startIndex, int endIndex, int k, int[] dp) {
        if(startIndex == arr.length){
            return 0;
        }

        if(dp[startIndex] != -1){
            return dp[startIndex];
        }

        int length = 0;
        int maxInPartition = Integer.MIN_VALUE;
        int maxAnswer = Integer.MIN_VALUE;

        for(int i=startIndex; i < Math.min(startIndex+k, endIndex); i++){
            length++;
            maxInPartition = Math.max(maxInPartition, arr[i]);
            int ansInPartition = length * maxInPartition + helper(arr, i+1, endIndex, k, dp);

            maxAnswer = Math.max(maxAnswer, ansInPartition);
        }
        return dp[startIndex] = maxAnswer;
    }
}
