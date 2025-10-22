package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {999999997,999999999,999999999};
        int k = 999999999;
        int numOperations = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxFrequency(nums, k, numOperations));
    }
}