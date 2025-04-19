package org.akhil;

public class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // Solution 1 - bruteforce recursive solution (O(4^(R*C))/O(R*C))   TLE
//    public int longestIncreasingPath(int[][] matrix) {
//        int longestPath = Integer.MIN_VALUE;
//
//        for(int i=0; i<matrix.length; i++){
//            for(int j=0; j<matrix[0].length; j++){
//                int currPath = explore(i, j, matrix);
//                longestPath = Math.max(longestPath, currPath);
//            }
//        }
//        return longestPath;
//    }
//
//    private int explore(int i, int j, int[][] matrix) {
//        int length = 1;             // because if no movement possible then as well the position at which we are will contribute to 1 node or length of 1.
//        for(int[] direction:directions){
//            int newI = i + direction[0];
//            int newJ = j + direction[1];
//
//            if(newI < 0 || newI >= matrix.length || newJ < 0 || newJ >= matrix[0].length || matrix[i][j] >= matrix[newI][newJ]){
//                continue;
//            }
//            int currLength = 1 + explore(newI, newJ, matrix);
//            length = Math.max(length, currLength);
//        }
//        return length;
//    }

    // Solution 2 - Memoization     (O(R*C)/O(R*C))
//    public int longestIncreasingPath(int[][] matrix) {
//        int longestPath = Integer.MIN_VALUE;
//        int[][] dp = new int[matrix.length][matrix[0].length];
//
//        for(int i=0; i<matrix.length; i++){
//            for(int j=0; j<matrix[0].length; j++){
//                int currPath = explore(i, j, matrix, dp);
//                longestPath = Math.max(longestPath, currPath);
//            }
//        }
//        return longestPath;
//    }
//
//    private int explore(int i, int j, int[][] matrix, int[][] dp) {
//
//        if(dp[i][j] != 0){
//            return dp[i][j];
//        }
//
//        int length = 1;             // because if no movement possible then as well the position at which we are will contribute to 1 node or length of 1.
//        for(int[] direction:directions){
//            int newI = i + direction[0];
//            int newJ = j + direction[1];
//
//            if(newI < 0 || newI >= matrix.length || newJ < 0 || newJ >= matrix[0].length || matrix[i][j] >= matrix[newI][newJ]){
//                continue;
//            }
//            int currLength = 1 + explore(newI, newJ, matrix, dp);
//            length = Math.max(length, currLength);
//        }
//        dp[i][j] = length;
//        return length;
//    }


    // Same approach but simplified for understanding   (O(R*C)/O(R*C))
    public int longestIncreasingPath(int[][] matrix) {
        int longestPath = Integer.MIN_VALUE;

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int currPath = explore(i, j, matrix, dp);
                longestPath = Math.max(longestPath, currPath);
            }
        }
        return longestPath;
    }

    private int explore(int i, int j, int[][] matrix, int[][] dp) {

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int length = 1;       // because if no movement possible then as well the position at which we are will contribute to 1 node or length of 1.

        // up
        if(i > 0 && matrix[i][j] < matrix[i-1][j]) {
            length = 1 + explore(i-1, j, matrix, dp);
        }
        // down
        if (i < matrix.length -1 && matrix[i][j] < matrix[i+1][j]) {
            length = Math.max(length, 1+explore(i+1, j, matrix, dp));
        }
        // left
        if (j > 0 && matrix[i][j] < matrix[i][j-1]) {
            length = Math.max(length, 1+ explore(i, j-1, matrix, dp));
        }
        //right
        if (j < matrix[0].length-1 && matrix[i][j] < matrix[i][j+1]) {
            length = Math.max(length, 1+ explore(i, j+1, matrix, dp));
        }
        dp[i][j] = length;
        return length;
    }
}
