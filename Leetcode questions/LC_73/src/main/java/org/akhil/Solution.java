package org.akhil;

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zeroInFirstRow = false;
        boolean zeroInFirstCol = false;

        // check zero in first column
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                zeroInFirstCol = true;
            }
        }

        // check zero in first row
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i] == 0){
                zeroInFirstRow = true;
            }
        }

        // check zero in rest of the matrix
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // update matrix based on first row
        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j=1; j<matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // update matrix based on first column
        for(int j=1; j<matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for(int i=1; i<matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        // update first column
        if(zeroInFirstCol){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        // update first row
        if(zeroInFirstRow){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }
}
