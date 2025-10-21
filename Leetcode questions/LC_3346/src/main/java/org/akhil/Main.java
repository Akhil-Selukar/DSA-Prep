package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,4,5};
        int k = 1;
        int numOperations = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxFrequency(nums, k, numOperations));
    }
}