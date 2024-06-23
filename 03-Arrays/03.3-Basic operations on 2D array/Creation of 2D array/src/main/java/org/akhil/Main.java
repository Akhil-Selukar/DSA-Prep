package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Declaration
        int[][] matrix;
        // Instantiation
        matrix = new int[2][2];

        // Initialization
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;

        System.out.println(Arrays.deepToString(matrix));

        int[][] newMatrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(Arrays.deepToString(newMatrix));
    }
}