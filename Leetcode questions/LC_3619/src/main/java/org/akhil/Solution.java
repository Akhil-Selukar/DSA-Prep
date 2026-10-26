package org.akhil;

public class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int result = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    if(((helper(grid, i, j, visited)) % k) == 0 ){
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private long helper(int[][] grid, int row, int col, boolean[][] visited){
        if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] == 0 || visited[row][col]){
            return 0;
        }

        visited[row][col] = true;
        long sum = grid[row][col]
                + helper(grid, row+1, col, visited)
                + helper(grid, row-1, col, visited)
                + helper(grid, row, col-1, visited)
                + helper(grid, row, col+1, visited);

        return sum;
    }
}
