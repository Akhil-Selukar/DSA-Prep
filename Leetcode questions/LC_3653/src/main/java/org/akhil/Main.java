package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,3,1,5,4};
        int[][] queries = {{1,4,2,3},{0,2,1,2}};

        Solution solution = new Solution();
        System.out.println(solution.xorAfterQueries(nums, queries));
    }
}