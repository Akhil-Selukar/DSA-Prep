package org.akhil;

public class Solution {

    // TC -> O(M^2 * N^2)
    // SC -> O(M*N) for rotated matrix
    public int minimumSum(int[][] grid) {
        // here as we need to divide the grid into exactly 3 parts. So to divide the grid in three parts we will have to
        // draw exactly 2 lines (see the image attached in readme.md. There are 6 possibilities to draw the lines and divide
        // the grid in 3 parts. Use all this 6 cases and explore all divisions of the grid.
        // After dividing the grid in 3 parts, each part can be solved like '3195. Find the Minimum Area to Cover All Ones I'
        // and combine the result to get entire area and then find the minimum of it as result.

        // if we observe the image carefully, we can see that case 4 is just case 1 rotated 90 degree clockwise
        // case 5 is case 2 rotated 90 degree clockwise and case 6 is case 3 rotated 90 degree clockwise. So this we can use and
        // write code for first 3 cases and then after computing all the 3 cases on given grid we can rotate the grid 90 degree clockwise and
        // then again pass the rotated matrix through the same 3 cases which will be indirectly like calculating case 4, 5 and 6.
        int m = grid.length;
        int n = grid[0].length;

        int result = Integer.MAX_VALUE;

        // for loop for case 1 and 2
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int case1 = caseOneArea(grid, i, j);
                int case2 = caseTwoArea(grid, i, j);
                result = Math.min(result, Math.min(case1, case2));
            }
        }

        // for loop for case 3
        for (int i = 1; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int case3 = caseThreeArea(grid, i, j);
                result = Math.min(result, case3);
            }
        }

        // rotate grid
        grid = rotateGridClockwise(grid);
        // M and N might change after rotation, hence recalculate
        m = grid.length;
        n = grid[0].length;

        // for loop for case 4 and 5
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int case4 = caseOneArea(grid, i, j);
                int case5 = caseTwoArea(grid, i, j);
                result = Math.min(result, Math.min(case4, case5));
            }
        }

        // for loop for case 6
        for (int i = 1; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int case6 = caseThreeArea(grid, i, j);
                result = Math.min(result, case6);
            }
        }

        return result;
    }

    private int[][] rotateGridClockwise(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rotated = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - i - 1] = grid[i][j];
            }
        }
        return rotated;
    }

    private int caseOneArea(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        int part1 = findAllOnesArea(grid, 0, i, 0, n);
        int part2 = findAllOnesArea(grid, i, m, 0, j);
        int part3 = findAllOnesArea(grid, i, m, j, n);

        return part1 + part2 + part3;
    }

    private int caseTwoArea(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        int part1 = findAllOnesArea(grid, 0, i, 0, j);
        int part2 = findAllOnesArea(grid, 0, i, j, n);
        int part3 = findAllOnesArea(grid, i, m, 0, n);

        return part1 + part2 + part3;
    }

    private int caseThreeArea(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        int part1 = findAllOnesArea(grid, 0, i, 0, n);
        int part2 = findAllOnesArea(grid, i, j, 0, n);
        int part3 = findAllOnesArea(grid, j, m, 0, n);

        return part1 + part2 + part3;
    }

    private int findAllOnesArea(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {

        int rs = grid.length;
        int re = 0;
        int cs = grid[0].length;
        int ce = 0;

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (grid[i][j] == 1) {
                    rs = Math.min(rs, i);
                    re = Math.max(re, i);
                    cs = Math.min(cs, j);
                    ce = Math.max(ce, j);
                }
            }
        }

        return (re - rs + 1) * (ce - cs + 1);

    }
}
