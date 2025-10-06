package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(M*N)/O(M*N)
public class Solution {

    int[][] directions = {{-1, 0}, {0, -1}, {1,0}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        // to store from what all cells we can visit respective ocean
        boolean[][] canVisitPacific = new boolean[m][n];
        boolean[][] canVisitAtlantic = new boolean[m][n];

        // all cells from first row can visit Pacific and all cells from last row can visit atlantic ocean
        // hence start from that row and check in reverse direction till which cell we can go and mark them
        for(int col=0; col<n; col++){     // we are keeping row constant and changing column hence col<n
            canVisit(0, col, heights, -1, -1, canVisitPacific);     // first row
            canVisit(m-1, col, heights, -1, -1, canVisitAtlantic);      // last row
        }

        // similarly left/first column is connected to pacific hence water can flow in pacific ocean from all cell of first column
        // and last column is connected to atlantic hence water can flow from all cells of last column to atlantic ocean.
        // check for all inner cells in reverse direction i.e. can water flow from ocean to land (reversing the logic)
        for(int row=0; row<m; row++){
            canVisit(row, 0, heights, -1, -1, canVisitPacific);
            canVisit(row, n-1, heights, -1, -1, canVisitAtlantic);
        }

        // check cells which can be visited by both oceans those will be the answer
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(canVisitPacific[i][j] && canVisitAtlantic[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }


    // DFS logic to mark all cells where we can go from ocean
    private void canVisit(int currRow, int currCol, int[][] heights, int prevRow, int prevCol, boolean[][] ocean){
        // if curr row and col are out of bounds or height of current cell is greater than previous (as we are going reverse direction ocean to land)
        // we cant go the curr cell
        if(currRow < 0 || currCol < 0 || currRow >= heights.length || currCol >= heights[0].length
                || (prevRow >=0 && prevCol >= 0 && heights[prevRow][prevCol] > heights[currRow][currCol])            // prevRow and prevCol >= 0 to prevent oob
                || ocean[currRow][currCol]){        // should not be already visited
            return;
        }

        ocean[currRow][currCol] = true;

        // go to all 4 directions from curr cell
        canVisit(currRow+1, currCol, heights, currRow, currCol, ocean);
        canVisit(currRow, currCol+1, heights, currRow, currCol, ocean);
        canVisit(currRow-1, currCol, heights, currRow, currCol, ocean);
        canVisit(currRow, currCol-1, heights, currRow, currCol, ocean);
    }
}
