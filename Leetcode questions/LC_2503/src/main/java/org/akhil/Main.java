package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{2,5,7},{3,5,1}};
        int[] queries = {5,6,2};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxPoints(grid, queries)));
    }
}