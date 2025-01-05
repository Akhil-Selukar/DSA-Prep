package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int target = 3;
//        int[] nums = {0,0,0,0,0,0,0,0,1};
//        int target = 1;

        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}