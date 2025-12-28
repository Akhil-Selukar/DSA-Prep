package org.akhil;

public class Solution {
    // Solution 1 - bruteforce
    // O(M*N)/O(1)
//    public int countNegatives(int[][] grid) {
//        int count = 0;
//        for(int i=0; i<grid.length; i++){
//            for(int j=0; j<grid[i].length; j++){
//                if(grid[i][j] < 0){
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }

    // ---------------------
    // Solution 2 - using binary search
    // O(M+N)/O(1)
    public int countNegatives(int[][] grid) {
        int count = 0;
        int row = 0;
        int col = grid[0].length-1;
        int totalRows = grid.length-1;

        while(row < grid.length && col >= 0){
            if(grid[row][col] < 0){
                count = count + (totalRows - row) + 1;      // as soon as we found a -ve, we know that entire column below that -ve index will be -ve.
                col--;
            } else {
                row++;
            }
        }

        return count;
    }
}
