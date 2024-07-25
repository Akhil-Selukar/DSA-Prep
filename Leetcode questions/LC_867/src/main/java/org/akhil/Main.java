package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(Arrays.deepToString(transpose(matrix)));
    }

// Below solution only for square matrix
//    public static int[][] transpose(int[][] matrix) {
//        for(int row=0; row<matrix.length; row++){
//            for(int col=row; col<matrix.length; col++){
//                int temp = matrix[row][col];
//                matrix[row][col]=matrix[col][row];
//                matrix[col][row] = temp;
//            }
//        }
//        return matrix;
//    }

//    for any M*N Matrix
    public static int[][] transpose(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];

        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[row].length; col++){
                transposed[col][row] = matrix[row][col];
            }
    }
    return transposed;
}
}