package org.akhil;

public class Solution {

    // TC -> O((Min(M,N)*M*N)*(M+N))
    // SC -> O(M*N)
    int[][] rowPref, colPref, diag1Pref, diag2Pref;
    public int largestMagicSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxSide = 1;    // as it is given that 1X1 matrix is always a magic matrix.

        // pre-computation of prefix sum
        buildPrefix(grid, rows, cols);          // O(M*N)

        // O(Min(M,N)*M*N*(M+N))
        for(int sideLen=2; sideLen<=Math.min(rows,cols); sideLen++){
            for(int row=0; sideLen+row <= rows; row++){
                for(int col=0; sideLen+col <= cols; col++){
                    if(isMagic(row, col, sideLen)){
                        maxSide = Math.max(maxSide, sideLen);
                    }
                }
            }
        }
        return maxSide;
    }

    private void buildPrefix(int[][] grid, int rows, int cols) {

        rowPref = new int[rows][cols+1];
        colPref = new int[rows+1][cols];
        diag1Pref = new int[rows+1][cols+1];
        diag2Pref = new int[rows+1][cols+1];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                rowPref[i][j+1] = rowPref[i][j] + grid[i][j];
                colPref[i + 1][j] = colPref[i][j] + grid[i][j];
                diag1Pref[i + 1][j + 1] = diag1Pref[i][j] + grid[i][j];
                diag2Pref[i + 1][j] = diag2Pref[i][j + 1] + grid[i][j];
            }
        }
    }

    // O(M+N)
    private boolean isMagic(int row, int col, int sideLen){
        int targetSum = rowPref[row][col + sideLen] - rowPref[row][col];

        // check all rows in current range
        for(int i=row; i < row+sideLen; i++) {
            if (rowPref[i][col+sideLen] - rowPref[i][col] != targetSum)
                return false;
        }

        // check all columns in current range
        for(int j=col; j < col+sideLen; j++) {
            if (colPref[row+sideLen][j] - colPref[row][j] != targetSum)
                return false;
        }

        // check first diagonal
        if(diag1Pref[row+sideLen][col+sideLen] - diag1Pref[row][col] != targetSum) {
            return false;
        }
        if(diag2Pref[row+sideLen][col] - diag2Pref[row][col+sideLen] != targetSum){
            return false;
        }

        return true;
    }
}
