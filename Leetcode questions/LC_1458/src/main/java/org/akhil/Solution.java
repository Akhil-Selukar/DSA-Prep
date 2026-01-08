package org.akhil;

import java.util.Arrays;

public class Solution {

//    // Solution 1 - Normal recursion
//    // O(3^(M*N)) will give TLE
//    public int maxDotProduct(int[] nums1, int[] nums2) {
//        return helper(nums1, nums2, 0, 0);
//    }
//
//    private int helper(int[] nums1, int[] nums2, int index1, int index2){
//        // if we reach to the end of any index we can not pick any more elements
//        // as we need to ensure that both subsequences has to be of same length
//        if(index1 >= nums1.length || index2 >= nums2.length){
////            return 0;   // if we are not picking any element then product will be 0 (This will not work because there can be -ve answer as well)
//            return Integer.MIN_VALUE;   // to handle -ve max dot product we need to return - infinity
//        }
//
//        // there can be 3 cases now
//        // case 1 - skip element from nums1 and keep nums2 index as it is
//        int case1 = helper(nums1, nums2, index1+1, index2);
//
//        // case 2 - skip element from nums2 and keep nums1 as it is
//        int case2 = helper(nums1, nums2, index1, index2+1);
//
//        // case 3 - take the element from both and add it's product in total sum and
//        // move to next index in both array
//        int case3 = (nums1[index1] * nums2[index2]) + Math.max(0, helper(nums1, nums2, index1+1, index2+1));
//        // as we are returning -infinity from base case hence we need to take max between 0 or returned value above
//
//        // return whatever is max from all 3 cases
//        return Math.max(case1, Math.max(case2, case3));
//    }


    // ---------------------
    // Solution 2 - Recursion with Memoization
    // O(M*N)/O(M*N)
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return helper(nums1, nums2, 0, 0, dp);
    }

    private int helper(int[] nums1, int[] nums2, int index1, int index2, int[][] dp){
        // if we reach to the end of any index we can not pick any more elements
        // as we need to ensure that both subsequences has to be of same length
        if(index1 >= nums1.length || index2 >= nums2.length){
//            return 0;   // if we are not picking any element then product will be 0 (This will not work because there can be -ve answer as well)
            return Integer.MIN_VALUE;   // to handle -ve max dot product we need to return - infinity
        }

        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }

        // there can be 3 cases now
        // case 1 - skip element from nums1 and keep nums2 index as it is
        int case1 = helper(nums1, nums2, index1+1, index2, dp);

        // case 2 - skip element from nums2 and keep nums1 as it is
        int case2 = helper(nums1, nums2, index1, index2+1, dp);

        // case 3 - take the element from both and add it's product in total sum and
        // move to next index in both array
        int case3 = (nums1[index1] * nums2[index2]) + Math.max(0, helper(nums1, nums2, index1+1, index2+1, dp));
        // as we are returning -infinity from base case hence we need to take max between 0 or returned value above

        // return whatever is max from all 3 cases
        return dp[index1][index2] = Math.max(case1, Math.max(case2, case3));
    }
}
