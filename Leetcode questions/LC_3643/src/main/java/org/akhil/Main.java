package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int x = 1;
        int y = 0;
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.reverseSubmatrix(grid, x, y, k));
    }
}