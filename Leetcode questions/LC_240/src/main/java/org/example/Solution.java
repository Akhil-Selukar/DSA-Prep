package org.example;

public class Solution {
    // Solution 1 - recursion
//    public boolean searchMatrix(int[][] matrix, int target) {
//
//        int rowStart = 0;
//        int columnStart = matrix[0].length-1;
//
//        return helper(matrix ,rowStart, columnStart, target);
//    }
//
//    private boolean helper(int[][] matrix, int rowStart, int columnStart, int target) {
//        if(rowStart >= matrix.length || columnStart < 0){
//            return false;
//        }
//
//        if(matrix[rowStart][columnStart] == target){
//            return true;
//        }
//
//        if(matrix[rowStart][columnStart] < target){
//            rowStart++;
//        } else if(matrix[rowStart][columnStart] > target){
//            columnStart--;
//        }
//
//        return helper(matrix, rowStart, columnStart, target);
//    }


    // Solution 2 - while loop
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowStart = 0;
        int columnStart = matrix[0].length-1;

        while(rowStart < matrix.length && columnStart >= 0){
            if(matrix[rowStart][columnStart] == target){
                return true;
            }

            if(matrix[rowStart][columnStart] < target){
                rowStart++;
            } else if(matrix[rowStart][columnStart] > target){
                columnStart--;
            }
        }

        return false;
    }
}
