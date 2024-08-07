package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        * Here important point to note is that the array is perfectly sorted.
        * which means if we write below array in single line ([[1,2,3,4],[5,6,7,8],[9,10,11,12]])
        * we can clearly see that for any element all the element to left is smaller than itself and
        * all the elements to the right are greater than the element itself.
        * */

        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        int target = 13;

        System.out.println(Arrays.toString(searchMatrix(matrix, target)));
    }

    public static int[] searchMatrix(int[][] matrix, int target) {
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        int colMid = colStart + (colEnd - colStart)/2;
        int rowStart = 0;
        int rowEnd = matrix.length-1;

        while(rowStart < rowEnd-1){
            int rowMid = rowStart + (rowEnd - rowStart)/2;

            if(target == matrix[rowMid][colMid]){
                return new int[]{rowMid, colMid};
            } else if(target < matrix[rowMid][colMid]){
                rowEnd = rowMid;
            } else {
                rowStart = rowMid;
            }
        }

        // Check the middle column of remaining two rows
        if(target == matrix[rowStart][colMid]){
            return new int[]{rowStart, colMid};
        }
        if(target == matrix[rowEnd][colMid]){
            return new int[]{rowEnd, colMid};
        }
        // Check the LHS of first row
        if(target < matrix[rowStart][colMid]){
            return binarySearch(matrix, rowStart, 0, colMid-1, target);
        }

        // Check the RHS of first row
        if(target > matrix[rowStart][colMid] && target < matrix[rowEnd][0]){
            return binarySearch(matrix, rowStart, colMid+1, matrix[rowStart].length-1, target);
        }
        // Check the LHS of second row
        if(target < matrix[rowEnd][colMid]){
            return binarySearch(matrix, rowEnd, 0, colMid-1, target);
        }
        // Check the RHS of second row
        if(target > matrix[rowEnd][colMid]){
            return binarySearch(matrix, rowEnd, colMid+1, matrix[rowEnd].length-1, target);
        }
        return new int[]{-1,-1};
    }

    private static int[] binarySearch(int[][] matrix, int row, int startIndex, int endIndex, int target){

        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(target == matrix[row][midIndex]){
                return new int[]{row, midIndex};
            } else if (target < matrix[row][midIndex]){
                endIndex = midIndex-1;
            } else {
                startIndex = midIndex+1;
            }
        }
        return new int[]{-1,-1};
    }
}