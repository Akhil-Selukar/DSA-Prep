package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {-5,1,2,-3,4};
//        int k = 2;

        int[] nums = {1,2};
        int k = 1;

        Solution solution = new Solution();
        System.out.println(solution.maxSubarraySum(nums, k));
    }
}