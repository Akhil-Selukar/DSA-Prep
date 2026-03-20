package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,-2,3},{2,3,5}};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.minAbsDiff(grid, k)));
    }
}