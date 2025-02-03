package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;

        Solution solution = new Solution();
        System.out.println(solution.checkSubarraySum(nums, k));
    }
}