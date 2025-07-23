package org.akhil;

public class NumMatrix {
    // Solution 1 - Bruteforce
    // O(M*N)/O(M*N)
//    int[][] board;
//    public NumMatrix(int[][] matrix) {
//        board = matrix;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for(int i=row1; i<=row2; i++){
//            for(int j=col1; j<=col2; j++){
//                sum = sum + board[i][j];
//            }
//        }
//
//        return sum;
//    }


    //------------------------
    // Solution 2 - Using prefixSum
    // O(M*N)/O(M*N)

    int[][] board;      // to store prefix sum of each row
    public NumMatrix(int[][] matrix) {      // O(M*N)/O(M*N)
        int m = matrix.length;
        int n = matrix[0].length;
        board = new int[m][n];

        for(int i=0; i<m; i++){
            board[i][0] = matrix[i][0];
            for(int j=1; j<n; j++){
                board[i][j] = board[i][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {      // O(M)/O(1)
        int sum = 0;

        for(int i=row1; i<=row2; i++) {
            sum = sum + board[i][col2] - (col1 == 0 ? 0 : board[i][col1-1]);
        }

        return sum;
    }
}
