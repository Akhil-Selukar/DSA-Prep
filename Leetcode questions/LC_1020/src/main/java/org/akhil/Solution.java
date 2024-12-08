package org.akhil;

public class Solution {

    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        // check the edges
        for(int i=0; i<grid.length; i++){
            // left edge
            if(grid[i][0] == 1 && !visited[i][0]){
                visited[i][0] = true;
                dfs(grid, visited, i, 0);
            }

            // right edge
            if(grid[i][grid[0].length-1] == 1 && !visited[i][grid[0].length-1]){
                visited[i][grid[0].length-1] = true;
                dfs(grid, visited, i, grid[0].length-1);
            }
        }

        for(int j=0; j<grid[0].length; j++){
            // upper edge
            if(grid[0][j] == 1 && !visited[0][j]){
                visited[0][j] = true;
                dfs(grid, visited, 0, j);
            }

            // lower edge
            if(grid[grid.length-1][j] == 1 && !visited[grid.length-1][j]){
                visited[grid.length-1][j] = true;
                dfs(grid, visited, grid.length-1, j);
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        for(int[] direction:directions){
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if(newI >= 0 && newJ >= 0 && newI < grid.length && newJ < grid[0].length && grid[newI][newJ] == 1 && !visited[newI][newJ]){
                visited[newI][newJ] = true;
                dfs(grid, visited, newI, newJ);
            }
        }
    }
}
