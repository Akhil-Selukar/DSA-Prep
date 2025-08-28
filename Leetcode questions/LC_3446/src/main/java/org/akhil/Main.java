package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,7,3},{9,8,2},{4,5,6}};

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.sortMatrix(grid)));
    }
}