package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int colStart = 0;
        int colEnd = mat.length-1;

        while((colStart<mat.length) && (colEnd>=0)){
            if(colStart==colEnd){
                sum += mat[colStart][colEnd];
            }else{
                sum += mat[colStart][colStart] + mat[colStart][colEnd];
            }
            colStart++;
            colEnd--;
        }
        return sum;
    }
}