package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - calculate height of each column at every row and find the max area
    // TC -> O(R*(C+ClogC+C) -> O(R*(C+ClogC)
    // SC -> O(C)
    // where R is number of rows and C is number of columns
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] currHeight = new int[cols];       // to store accumulated ones
        int result = 0;

        // we need to traverse each column of current row and accumulate the ones
        for(int row=0; row<rows; row++){

            // accumulate the 1's
            for(int col=0; col<cols; col++){
                if(matrix[row][col] == 1){
                    currHeight[col]++;
                } else {
                    currHeight[col] = 0;    // the continuity is broken here so we can not extend the height
                }
            }

            // now rearrange the heights and check the max area
            int[] heights = currHeight.clone(); // this is important because we do need original heights array to further accumulate next row.
            Arrays.sort(heights);

            for(int i=0; i<cols; i++){
                int height = heights[i];
                int width = cols-i;
                result = Math.max(result, height*width);
            }
        }
        return result;
    }
}
