package org.akhil;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int firstRow = 0;
        int lastCol = matrix[0].length-1;

        while(firstRow<matrix.length && lastCol>=0){
            if(matrix[firstRow][lastCol] == target){
                return true;
            }

            if(matrix[firstRow][lastCol] < target){
                firstRow++;
            } else {
                lastCol--;
            }
        }

        return false;
    }
}
