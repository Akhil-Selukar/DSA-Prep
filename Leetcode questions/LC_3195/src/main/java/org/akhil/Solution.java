package org.akhil;

public class Solution {
    // Solution 1 - Bruteforce (by flattening rows and columns)
    // O(M*N)/O(M+N)
//    public int minimumArea(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int[] flattenedRow = new int[m];
//        int[] flattenedCol = new int[n];
//
//        // populate flattenedRow and Column
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                flattenedRow[i] = flattenedRow[i] | grid[i][j];
//            }
//        }
//
//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                flattenedCol[i] = flattenedCol[i] | grid[j][i];
//            }
//        }
//
//        // find 1st and last occurrence of 1 in flattened arrays
//        int firstInRow = 0;
//        int lastInRow = 0;
//        int firstInCol = 0;
//        int lastInCol = 0;
//
//        for(int i=0; i<m; i++){
//            if(flattenedRow[i] == 1){
//                firstInRow = i;
//                break;
//            }
//        }
//
//        for(int i=m-1; i>=0; i--){
//            if(flattenedRow[i] == 1){
//                lastInRow = i;
//                break;
//            }
//        }
//
//        for(int i=0; i<n; i++){
//            if(flattenedCol[i] == 1){
//                firstInCol = i;
//                break;
//            }
//        }
//
//        for(int i=n-1; i>=0; i--){
//            if(flattenedCol[i] == 1){
//                lastInCol = i;
//                break;
//            }
//        }
//
//        // calculate the area and return;
//        int width = lastInCol - firstInCol + 1;
//        int height = lastInRow - firstInRow + 1;
//
//        return width * height;
//    }


    // -----------------------
    // Solution 2 - optimized (eliminated most of the for loops)
    // O(N*M)/O(1)
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int firstInRow = n;
        int lastInRow = 0;
        int firstInCol = m;
        int lastInCol = 0;


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    firstInRow = Math.min(firstInRow, j);
                    lastInRow = Math.max(lastInRow, j);
                    firstInCol = Math.min(firstInCol, i);
                    lastInCol = Math.max(lastInCol, i);
                }
            }
        }

        // calculate the area and return;
        int width = lastInCol - firstInCol + 1;
        int height = lastInRow - firstInRow + 1;

        return width * height;
    }
}
