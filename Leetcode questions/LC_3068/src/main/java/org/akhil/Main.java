package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int k = 3;
        int[][] edges = {{0,1},{0,2}};

        Solution solution = new Solution();
        System.out.println(solution.maximumValueSum(nums, k, edges));
    }
}