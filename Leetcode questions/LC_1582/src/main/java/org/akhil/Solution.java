package org.akhil;

public class Solution {
//    // Solution 1 - bruteforce
//    // O(M*N*(M+N))/O(1) if m=n then O(N^3)/O(1)
//    public int numSpecial(int[][] mat) {
//        int count = 0;
//
//        for(int i=0; i<mat.length; i++){
//            for(int j=0; j<mat[0].length; j++){
//                if(mat[i][j] == 1 && isSpecial(mat, i, j)){
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
//
//    private boolean isSpecial(int[][] mat, int row, int col){
//
//        // check vertically
//        for(int i=0; i<mat.length; i++){
//            if(i == row){
//                continue;
//            }
//
//            if(mat[i][col] == 1){
//                return false;
//            }
//        }
//
//        // check horizontally
//        for(int j=0; j<mat[0].length; j++){
//            if(j==col){
//                continue;
//            }
//
//            if(mat[row][j] == 1){
//                return false;
//            }
//        }
//        return true;
//    }

    // -------------------------
    // Solution 2 - Optimized (Precompute number of 1's in each row and column)
    // O(M*N)/O(1) if m=n then O(N^2)/O(M+N)
    public int numSpecial(int[][] mat) {
        int count = 0;
        int rows = mat.length;
        int cols = mat[0].length;

        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        for(int i=0; i<rows; i++){
            int oneInRow = 0;
            for(int j=0; j<cols; j++){
                if(mat[i][j] == 1){
                    oneInRow++;
                }
            }
            rowCount[i] = oneInRow;
        }

        for(int j=0; j<cols; j++){
            int oneInCol = 0;
            for(int i=0; i<rows; i++){
                if(mat[i][j] == 1){
                    oneInCol++;
                }
            }
            colCount[j] = oneInCol;
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1){
                    count++;
                }
            }
        }

        return count;
    }

}
