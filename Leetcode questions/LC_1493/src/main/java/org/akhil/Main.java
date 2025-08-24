package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {0,1,1,1,0,1,1,0,1};
//        int[] nums = {1,1,0,1};
        int[] nums = {1,1,1};

        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(nums));
    }
}