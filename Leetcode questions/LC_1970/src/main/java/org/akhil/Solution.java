package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution using binary search and dfs
    // TC -> O(logM * (R*C)) where M is the length of cells array and R is row and C is col. We are running binary search on cells array length and each time we are calling dfs which will be O(M*N)
    // SC -> O(R*C) for grid creation for each dfs (every time we are creating new grid, but at a time there will be only one grid in system hence O(R*C))
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int min = 0;
        int max = cells.length-1;
        int lastDay = 0;

        while(min <= max){
            int mid = min + (max-min)/2;

            if(canCross(row, col, cells, mid)){
                lastDay = mid;
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        return lastDay;
    }

    private boolean canCross(int m, int n, int[][] cells, int mid){
        boolean[][] grid = new boolean[m][n];

        // initially every cell is land
        for(boolean[] row:grid){
            Arrays.fill(row, true);     // true - land - 0
        }

        // mark cells till mid as water
        for(int i=0; i<mid; i++){
            int row = cells[i][0]-1;
            int col = cells[i][1]-1;

            grid[row][col] = false;         // false - water - 1
        }

        // check if we can go from top to bottom.
        // we can start from any cell from top row so we need to check from all cells (i.e. all column index)
        for(int i=0; i<n; i++){   //
            if(grid[0][i] && dfs(grid, 0, i)){
                return true;
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] grid, int currRow, int currCol){

        // if we went OOB or curr cell is water then we can't move ahead
        if(currRow < 0 || currCol < 0 || currRow >= grid.length || currCol >= grid[0].length || !grid[currRow][currCol]){
            return false;
        }

        // we reach to the last row (no matter at which cell hence we are checking only row)
        if(currRow == grid.length-1){
            return true;
        }

        // else check all 4 directions
        grid[currRow][currCol] = false;     // this is visited and we don't want to go here again.
        for(int[] direction:directions){
            int nextRow = currRow + direction[0];
            int nextCol = currCol + direction[1];

            if(dfs(grid, nextRow, nextCol)){
                return true;
            }
        }
        // no need to backtrack the grid[currRow][currCol] = true as we are creating new boolean grid each time.
        return false;
    }
}
