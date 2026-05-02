package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0, 1},{2, 0}};
        int k = 1;

        Solution solution = new Solution();
        System.out.println(solution.maxPathScore(grid, k));
    }
}