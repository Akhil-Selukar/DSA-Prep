package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxSubarrayLength(nums, k));
    }
}