package org.akhil;

public class Solution {

    // Solution 1
    // TC -> O(M*N) where M is number of rows and N is number of columns
    // SC -> O(N) i.e. number of columns
    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] lastColSum = new int[cols];

        for(int row=0; row<rows; row++){
            int currRowSum = 0;
            for(int col=0; col<cols; col++){
                lastColSum[col] = lastColSum[col] + grid[row][col] + currRowSum;
                currRowSum = currRowSum + grid[row][col];

                if(lastColSum[col] <= k){
                    count++;
                }
            }
        }

        return count;
    }
}
