package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,3,2,2};
//        int[] nums = {1,2,3,4};
        int[] nums = {1,2,2,2,3,3};

        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(nums));
    }
}