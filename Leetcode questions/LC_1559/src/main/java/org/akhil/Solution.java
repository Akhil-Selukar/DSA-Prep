package org.akhil;

public class Solution {

    // O(M*N)/O(M*N)
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!visited[i][j]) {
                    if (checkCycle(grid, i, j, -1, -1, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkCycle(char[][] grid, int row, int col, int parentRow, int parentCol, boolean[][] visited){
        // otherwise mark the position as visited and explore other directions
        visited[row][col] = true;

        for(int[] direction:directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && grid[newRow][newCol] == grid[row][col]){
                if(!visited[newRow][newCol]){
                    if(checkCycle(grid, newRow, newCol, row, col, visited)){
                        return true;
                    }
                } else if(newRow != parentRow || newCol != parentCol){
                    return true;
                }
            }
        }
        return false;
    }
}
