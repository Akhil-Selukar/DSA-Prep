package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,0,1};
        int[][] queries = {{0,2}};

//        int[] nums = {4,3,2,1};
//        int[][] queries = {{1,3},{0,2}};

        Solution solution = new Solution();
        System.out.println(solution.isZeroArray(nums, queries));
    }
}