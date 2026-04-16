package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,1,4,1,3,2};
        int[] queries = {0,3,5};

        Solution solution = new Solution();
        System.out.println(solution.solveQueries(nums, queries));
    }
}