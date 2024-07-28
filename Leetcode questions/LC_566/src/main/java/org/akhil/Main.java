package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}};
        int r = 1;
        int c = 4;

        System.out.println(Arrays.deepToString(matrixReshape(mat, r,c)));
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int matRow = mat.length;
        int matCol = mat[0].length;

        if((r*c) != (matRow*matCol))
            return mat;

        int[][] ans = new int[r][c];
        int rowIndex=0;
        int colIndex=0;

        for(int row=0; row<mat.length; row++){
            for(int col=0; col<mat[row].length; col++){
                ans[rowIndex][colIndex] = mat[row][col];
                colIndex++;

                if(colIndex == c){
                    rowIndex++;
                    colIndex = 0;
                    if((rowIndex >= r) || (colIndex >= c)) break;
                }
            }
        }
        return ans;
    }
}