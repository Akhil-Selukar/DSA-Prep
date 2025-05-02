package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.gardenNoAdj(n, paths)));
    }
}