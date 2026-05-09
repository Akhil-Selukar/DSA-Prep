package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.rotateGrid(grid, k)));
    }
}