package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,0,2};
        int[][] queries = {{0,2,1},{0,2,1},{1,1,3}};

        Solution solution = new Solution();

        System.out.println(solution.minZeroArray(nums, queries));
    }
}