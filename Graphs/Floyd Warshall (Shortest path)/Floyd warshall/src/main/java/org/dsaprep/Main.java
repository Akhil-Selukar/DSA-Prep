package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Question link - https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/

        int[][] grid = {{0, 1, 43},{1, 0, 6}, {-1, -1, 0}};

        Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.shortestDistance(grid)));
    }
}