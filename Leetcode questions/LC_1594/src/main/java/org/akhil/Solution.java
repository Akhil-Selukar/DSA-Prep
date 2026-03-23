package org.akhil;

public class Solution {

    // Solution 1 - DP
    // O(M*N)/O(M*N)
    final int MOD = (int)(7+1e9);
    public int maxProductPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        long[][] dpMax = new long[rows][cols];
        long[][] dpMin = new long[rows][cols];

        // fill first row and column in both the dp arrays
        dpMax[0][0] = dpMin[0][0] = grid[0][0];
        for(int row=1; row<rows; row++){
            dpMax[row][0] = dpMax[row-1][0] * grid[row][0];
            dpMin[row][0] = dpMin[row-1][0] * grid[row][0];
        }

        for(int col=1; col<cols; col++){
            dpMax[0][col] = dpMax[0][col-1] * grid[0][col];
            dpMin[0][col] = dpMin[0][col-1] * grid[0][col];
        }

        // check all places in grid and find min and max at each place
        for(int row=1; row<rows; row++){
            for(int col=1; col<cols; col++){
                int currVal = grid[row][col];

                long leftMaxProduct = dpMax[row][col-1] * currVal;
                long topMaxProduct = dpMax[row-1][col] * currVal;
                long leftMinProduct = dpMin[row][col-1] * currVal;
                long topMinProduct = dpMin[row-1][col] * currVal;

                dpMax[row][col] = Math.max(Math.max(topMaxProduct, topMinProduct), Math.max(leftMaxProduct, leftMinProduct));
                dpMin[row][col] = Math.min(Math.min(topMaxProduct, topMinProduct), Math.min(leftMaxProduct, leftMinProduct));
            }
        }

        long result = dpMax[rows-1][cols-1];
        return result < 0 ? -1 : (int)result%MOD;
    }
}
