package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{3,4,5,1,3},{3,3,4,2,3},{20,30,200,40,10},{1,5,5,4,1},{4,3,2,2,5}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getBiggestThree(grid)));
    }
}