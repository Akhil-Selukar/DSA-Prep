package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int[] nums = {2,5,6,8};
        int maxDiff = 2;
        int[][] queries = {{0,1},{0,2},{1,3},{2,3}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.pathExistenceQueries(n, nums, maxDiff, queries)));
    }
}