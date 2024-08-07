package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Here note that the matrix is sorted ascending row wise as well as column wise.
        int[][] matrix = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,36,48}
            };
        int target = 35;

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