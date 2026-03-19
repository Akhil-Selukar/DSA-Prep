package org.akhil;

public class Solution {
    // Solution
    // O(M*N)/O(N) where M is number of rows and N is number of columns in given grid
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int[][] dp = new int[cols][2];

        for(int row=0; row<rows; row++){
            int currRowX = 0;
            int currRowY = 0;
            for(int col=0; col<cols; col++){
                int currChar = grid[row][col];

                if(currChar == 'X'){
                    currRowX++;
                }
                if(currChar == 'Y'){
                    currRowY++;
                }
                dp[col][0] = dp[col][0] + currRowX;
                dp[col][1] = dp[col][1] + currRowY;

                if(dp[col][0] != 0 && (dp[col][0] == dp[col][1])){
                    count++;
                }
            }
        }

        return count;
    }
}
