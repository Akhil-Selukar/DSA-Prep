package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,3},{2,2}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findMissingAndRepeatedValues(grid)));
    }
}