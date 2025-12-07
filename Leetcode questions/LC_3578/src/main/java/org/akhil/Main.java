package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {9,4,1,3,7};
        int k = 4;

        Solution solution = new Solution();
        System.out.println(solution.countPartitions(nums, k));
    }
}