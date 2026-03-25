package org.akhil;

public class Solution {
    // O(M*N)/O(M+N)
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;


        int[] rowWiseSum = new int[rows];
        int[] colWiseSum = new int[cols];
        long totalSum = getAllSums(grid, rowWiseSum, colWiseSum);

        // check for vertical cut
        long leftSideSum = colWiseSum[0];
        for(int j=1; j<grid[0].length; j++){
            if(leftSideSum == totalSum-leftSideSum){
                return true;
            }
            leftSideSum = leftSideSum + colWiseSum[j];
        }

        // check for horizontal cut
        long aboveSum = rowWiseSum[0];
        for(int i=1; i<rows; i++){
            if(aboveSum == totalSum-aboveSum){
                return true;
            }
            aboveSum = aboveSum + rowWiseSum[i];
        }

        return false;
    }

    private long getAllSums(int[][] grid, int[] rowWiseSum, int[] colWiseSum){
        long totalSum = 0;

        // find total sum, rowWiseSum and colWiseSum
        for(int i=0; i<grid.length; i++){
            int currRowSum = 0;
            for(int j=0; j<grid[0].length; j++){
                currRowSum = currRowSum + grid[i][j];
                totalSum = totalSum + grid[i][j];
            }
            rowWiseSum[i] = currRowSum;
        }

        for(int j=0; j<grid[0].length; j++){
            int currColSum = 0;
            for(int i=0; i<grid.length; i++){
                currColSum = currColSum + grid[i][j];
            }
            colWiseSum[j] = currColSum;
        }

        return totalSum;
    }
}
