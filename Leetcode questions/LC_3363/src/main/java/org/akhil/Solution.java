package org.akhil;

import java.util.Arrays;

public class Solution {

//    // Solution 1 - Recursion with memoization
//    // Check the intuition before going through the solution
//    // O(N^2)/O(N^2)
//    public int maxCollectedFruits(int[][] fruits) {
//        int n = fruits.length;
//
//        int[][] dp = new int[n][n];
//        for(int[] row : dp){
//            Arrays.fill(row, -1);
//        }
//
//        int firstChildCollection = fruitCollector1(fruits);
//        int secondChildCollection = fruitCollector2(0, n-1 ,fruits, dp);
//        int thirdChildCollection = fruitCollector3(n-1, 0, fruits, dp);
//
//        return firstChildCollection + secondChildCollection + thirdChildCollection;
//    }
//
//    // O(N^2) (square because of memoization, otherwise it would have been O(N^3)
//    private int fruitCollector3(int row, int col, int[][] fruits, int[][] dp) {
//
//        // base case for oob
//        if(row < 0 || row >= fruits.length || col >= fruits.length){
//            return 0;
//        }
//
//        // base case for diagonal
//        if(row <= col){
//            return 0;
//        }
//
//        // last cell is already visited
//        if(row == fruits.length-1 && col == fruits.length-1){
//            return 0;
//        }
//
//        if(dp[row][col] != -1){
//            return dp[row][col];
//        }
//
//        // possible options to move
//        int option1 = fruits[row][col] + fruitCollector3(row-1, col+1, fruits, dp);
//        int option2 = fruits[row][col] + fruitCollector3(row, col+1, fruits, dp);
//        int option3 = fruits[row][col] + fruitCollector3(row+1, col+1, fruits, dp);
//
//        // Max of all options
//        return dp[row][col] = Math.max(option1, Math.max(option2, option3));
//    }
//
//    // O(N^2) (square because of memoization, otherwise it would have been O(N^3)
//    private int fruitCollector2(int row, int col, int[][] fruits, int[][] dp) {
//
//        // base cases for out of bounds
//        if(row >= fruits.length || col >= fruits.length || col < 0){
//            return 0;
//        }
//        // base case if child 2 tries to go below diagonal (here = also because we have to EXCLUDE diagonal as well)
//        if(row >= col){
//            return 0;
//        }
//
//        // last cell is already collected
//        if(row == fruits.length-1 && col == fruits.length-1){
//            return 0;
//        }
//
//        if(dp[row][col] != -1){
//            return dp[row][col];
//        }
//
//        // directions in which child 2 can move
//        int option1 = fruits[row][col] + fruitCollector2(row+1, col-1, fruits, dp);
//        int option2 = fruits[row][col] + fruitCollector2(row+1, col, fruits, dp);
//        int option3 = fruits[row][col] + fruitCollector2(row+1, col+1, fruits, dp);
//
//        // Maximum out of all options
//        return dp[row][col] = Math.max(option1, Math.max(option2, option3));
//
//    }
//
//    // O(N)
//    private int fruitCollector1(int[][] fruits) {
//        int count = 0;
//        for(int i=0; i<fruits.length; i++){
//            count = count + fruits[i][i];
//        }
//
//        return count;
//    }


    // Solution 2 - Using bottom up approach
    // Check the intuition before going through the solution
    // O(N^2)/O(N^2)
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int[][] dp = new int[n][n];


        int firstChildCollection = 0;
        // collect using child 1
        for(int i=0; i<n; i++){
            firstChildCollection = firstChildCollection + fruits[i][i];
        }

        // mark the cells which can not be visited by child 2 and child 3 (this is very imp)
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (i < j && i + j < n - 1) {   // triangle above diagonal marked with 0 (check README)
                    dp[i][j] = 0;
                } else if (i > j && i + j < n - 1) {    // triangle below diagonal marked with 0 (check README)
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = fruits[i][j];        // other places which can be visited.
                }
            }
        }

        // fill up the DP table for child 2
        for(int i=1; i<n; i++){
            for(int j=i+1; j<n; j++){       // j=i+1 because child2 can only move in cells above diagonal
                // max fruits can be collected at (i,j) = fruits present at (i,j) + max of all places from which we can visit (i,j)
                dp[i][j] = dp[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], (j+1<n ? dp[i-1][j+1] : 0)));
            }
        }

        // fill up DP table for child 3
        for(int j=1; j<n; j++){
            for(int i=j+1; i<n; i++){
                dp[i][j] = dp[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], (i+1<n ? dp[i+1][j-1] : 0)));
            }
        }

        return firstChildCollection + dp[n-2][n-1] + dp[n-1][n-2];
    }
}
