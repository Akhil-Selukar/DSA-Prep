package org.akhil;

public class Solution {
    // We are flipping matrix of K*K so outer while loop will run K/2 times and inner for loop will run K times for each out loop execution
    // Hence it will be O(K/2)*O(K) ~ O(K^2)/2 ~ O(K^2)
    // Now in worst case K can be N hence O(N^2)
    // O(N^2)/O(1)
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int startRow = x;
        int endRow = x+k;
        int startCol = y;
        int endCol = y+k;

        while(startRow < endRow){
            for(int col=startCol; col<endCol; col++){
                int temp = grid[startRow][col];
                grid[startRow][col] = grid[endRow-1][col];
                grid[endRow-1][col] = temp;
            }
            startRow++;
            endRow--;
        }
        return grid;
    }
}
