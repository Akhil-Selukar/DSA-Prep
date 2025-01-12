package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
//        int[] nums = {2,2,2,2,2};
        Solution solution = new Solution();
        System.out.println(solution.findNumberOfLIS(nums));
    }
}