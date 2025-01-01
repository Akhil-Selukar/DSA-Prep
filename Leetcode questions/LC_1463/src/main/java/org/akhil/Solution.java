package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution - 1 (Normal recursion)
//    public int cherryPickup(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        return cherryPicker(rows, cols, grid, 0, 0, cols-1);
//    }
//
//    private int cherryPicker(int rows, int cols, int[][] grid, int currentRow, int currentColOfR1, int currentColOfR2) {
//        if(currentColOfR1 < 0 || currentColOfR1 >= cols || currentColOfR2 < 0 || currentColOfR2 >= cols){
//            return (int)-1e9;
//        }
//        if(currentRow == rows-1){
//            if(currentColOfR1 == currentColOfR2){
//                return grid[currentRow][currentColOfR1];
//            } else {
//                return grid[currentRow][currentColOfR1] + grid[currentRow][currentColOfR2];
//            }
//        }
//
//        int maxCherriesPicked = (int)-1e9;
//        for(int colR1=-1; colR1<=1; colR1++){
//            for(int colR2=-1; colR2<=1; colR2++){
//                int ans;
//                if(currentColOfR1 == currentColOfR2){
//                    ans = grid[currentRow][currentColOfR1]
//                            + cherryPicker(rows, cols, grid, currentRow+1, currentColOfR1+colR1, currentColOfR2+colR2);
//                } else {
//                    ans = grid[currentRow][currentColOfR1]
//                            + grid[currentRow][currentColOfR2]
//                            + cherryPicker(rows, cols, grid, currentRow+1, currentColOfR1+colR1, currentColOfR2+colR2);
//                }
//                maxCherriesPicked = Math.max(maxCherriesPicked, ans);
//            }
//        }
//        return maxCherriesPicked;
//    }


    // Solution - 2 (Memoization)
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];
        for(int[][] outerArr:dp){
            for(int[] arr: outerArr){
                Arrays.fill(arr, -1);
            }
        }

        return cherryPicker(rows, cols, grid, 0, 0, cols-1, dp);
    }

    private int cherryPicker(int rows, int cols, int[][] grid, int currentRow, int currentColOfR1, int currentColOfR2, int[][][] dp) {
        if(currentColOfR1 < 0 || currentColOfR1 >= cols || currentColOfR2 < 0 || currentColOfR2 >= cols){
            return (int)-1e9;
        }
        if(currentRow == rows-1){
            if(currentColOfR1 == currentColOfR2){
                return grid[currentRow][currentColOfR1];
            } else {
                return grid[currentRow][currentColOfR1] + grid[currentRow][currentColOfR2];
            }
        }

        if(dp[currentRow][currentColOfR1][currentColOfR2] != -1){
            return dp[currentRow][currentColOfR1][currentColOfR2];
        }

        int maxCherriesPicked = (int)-1e9;
        for(int colR1=-1; colR1<=1; colR1++){
            for(int colR2=-1; colR2<=1; colR2++){
                int ans;
                if(currentColOfR1 == currentColOfR2){
                    ans = grid[currentRow][currentColOfR1]
                            + cherryPicker(rows, cols, grid, currentRow+1, currentColOfR1+colR1, currentColOfR2+colR2, dp);
                } else {
                    ans = grid[currentRow][currentColOfR1]
                            + grid[currentRow][currentColOfR2]
                            + cherryPicker(rows, cols, grid, currentRow+1, currentColOfR1+colR1, currentColOfR2+colR2, dp);
                }
                maxCherriesPicked = Math.max(maxCherriesPicked, ans);
            }
        }
        dp[currentRow][currentColOfR1][currentColOfR2] = maxCherriesPicked;
        return maxCherriesPicked;
    }
}
