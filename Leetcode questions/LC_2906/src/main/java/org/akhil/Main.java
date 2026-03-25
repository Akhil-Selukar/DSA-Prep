package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.constructProductMatrix(grid)));
    }
}