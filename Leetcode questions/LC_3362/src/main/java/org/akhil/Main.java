package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        int[][] queries = {{1,3},{0,2},{1,3},{1,2}};

        Solution solution = new Solution();
        System.out.println(solution.maxRemoval(nums, queries));
    }
}