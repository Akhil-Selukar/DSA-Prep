package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Here note that the matrix is sorted ascending row wise as well as column wise.
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
            };
        int target = 8;

        System.out.println(Arrays.toString(search(matrix, target)));
    }

    public static int[] search(int[][] matrix, int target){
        int row = 0;
        int col = matrix[0].length-1;

        while(row < matrix.length && col >= 0){
            if(target == matrix[row][col]){
                return new int[]{row, col};
            } else if(target<matrix[row][col]){
                col--;
            } else if(target>matrix[row][col]){
                row++;
            }
        }
        return new int[]{-1,-1};
    }
}