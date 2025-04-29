package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,2,1,3};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.countSubarrays(nums, k));
    }
}