package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,5,5,4,11};
        int[][] edges = {{0,1},{1,2},{1,3},{3,4}};

        Solution solution = new Solution();
        System.out.println(solution.minimumScore(nums, edges));
    }
}