package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // Solution 1 - Bruteforce
    // O(M*N)/O(1) - Extra space is only because of set which will at max contain 9 values hence O(1)
//    public int numMagicSquaresInside(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int result = 0;
//
//        if(rows < 3 || cols < 3){
//            return result;
//        }
//
//        for(int row=0; row<rows-2; row++){
//            for(int col=0; col<cols-2; col++){
//                if(check(grid, row, col)){
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean check(int[][] grid, int row, int col){
//        int sum = 0;
//        Set<Integer> distinct = new HashSet<>();
//        for(int i=row; i<=row+2; i++){
//            sum = sum + grid[i][col];
//        }
//
//        // check each row
//        for(int i=row; i<=row+2; i++){
//            int currSum = 0;
//            for(int j=col; j<=col+2; j++){
//                if(!distinct.add(grid[i][j])){
//                    return false;
//                }
//                if(grid[i][j] > 9 || grid[i][j] < 1){
//                    return false;
//                }
//                currSum = currSum+grid[i][j];
//            }
//
//            if(currSum != sum){
//                return false;
//            }
//        }
//
//        // check each column
//        for(int i=col; i<=col+2; i++){
//            int currSum = 0;
//            for(int j=row; j<=row+2; j++){
//                currSum = currSum+grid[j][i];
//            }
//
//            if(currSum != sum){
//                return false;
//            }
//        }
//
//        // check both diagonal
//        int d1Sum = grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2];
//        if(d1Sum != sum){
//            return false;
//        }
//
//        int d2Sum = grid[row+2][col]+grid[row+1][col+1]+grid[row][col+2];
//        if(d2Sum != sum){
//            return false;
//        }
//
//        return true;
//    }


    // ------------------
    // Solution 2 - Bruteforce (Slightly cleaned up code)
    // O(M*N)/O(1) - Extra space is only because of set which will at max contain 9 values hence O(1)
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;

        if(rows < 3 || cols < 3){
            return result;
        }

        for(int row=0; row<rows-2; row++){
            for(int col=0; col<cols-2; col++){
                if(check(grid, row, col)){
                    result++;
                }
            }
        }
        return result;
    }

    private boolean check(int[][] grid, int row, int col){
        int sum = 0;
        boolean[] visited = new boolean[10];

        // check for invalid element or duplicate element
        for(int i=row; i<=row+2; i++) {
            for (int j=col; j<=col+2; j++) {
                if(grid[i][j] > 9 || grid[i][j] < 1 || visited[grid[i][j]]){
                    return false;
                }
                visited[grid[i][j]] = true;
            }
        }

        for(int i=row; i<=row+2; i++){
            sum = sum + grid[i][col];
        }

        // check each row
        for(int i=row; i<=row+2; i++){
            int currSum = 0;
            for(int j=col; j<=col+2; j++){
                currSum = currSum+grid[i][j];
            }

            if(currSum != sum){
                return false;
            }
        }

        // check each column
        for(int i=col; i<=col+2; i++){
            int currSum = 0;
            for(int j=row; j<=row+2; j++){
                currSum = currSum+grid[j][i];
            }

            if(currSum != sum){
                return false;
            }
        }

        // check both diagonal
        int d1Sum = grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2];
        if(d1Sum != sum){
            return false;
        }

        int d2Sum = grid[row+2][col]+grid[row+1][col+1]+grid[row][col+2];
        if(d2Sum != sum){
            return false;
        }

        return true;
    }
}
