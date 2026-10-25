package org.akhil;

public class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
                mark(grid, i, 0);
            }

            if (grid[i][cols - 1] == 0) {
                mark(grid, i, cols - 1);
            }
        }

        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 0) {
                mark(grid, 0, i);
            }

            if (grid[rows - 1][i] == 0) {
                mark(grid, rows - 1, i);
            }
        }

        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    result++;
                    mark(grid, i, j);
                }
            }
        }

        return result;
    }

    private void mark(int[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] == 1) {
            return;
        }

        grid[row][col] = 1;

        mark(grid, row + 1, col);
        mark(grid, row, col + 1);
        mark(grid, row - 1, col);
        mark(grid, row, col - 1);
    }
}
