package org.akhil;

import java.util.Arrays;

public class Solution {
    int answer = Integer.MIN_VALUE;
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        helper(nums1, nums2, nums1.length-1, nums2.length-1, dp);
        return answer;
    }

    private int helper(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int length = 0;
        if(nums1[i] == nums2[j]){
            length = 1 + helper(nums1, nums2, i-1, j-1, dp);
        }
        answer = Math.max(answer, length);

        helper(nums1, nums2, i-1, j, dp);
        helper(nums1, nums2, i, j-1, dp);

        return dp[i][j] = length;
    }
}
