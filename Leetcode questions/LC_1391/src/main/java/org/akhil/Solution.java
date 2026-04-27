package org.akhil;

public class Solution {
    // O(M*N)/O(M*N)

    boolean[] canRight = {false, true, false, false, true, false, true};
    boolean[] canLeft = {false, true, false, true, true, true, false};
    boolean[] canUp = {false, false, true, false, false, true, true};
    boolean[] canDown = {false, false, true, true, true, false, false};
    int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
    public boolean hasValidPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        return dfs(grid, 0, 0, visited);
    }

    private boolean dfs(int[][] grid, int row, int col, boolean[][] visited){
        if(row == grid.length-1 && col == grid[0].length-1){
            return true;
        }

        visited[row][col] = true;

        for(int i=0; i<4; i++) {
            int[] direction = directions[i];
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && !visited[newRow][newCol] &&
                    canMove(grid[row][col], grid[newRow][newCol], i)) {
                if(dfs(grid, newRow, newCol, visited))
                    return true;
            }
        }
        return false;
    }

    // This we need to check because suppose current cell road is moving from left to right, but to actually reach to right we must have next cell
    // road which can accept someone coming from its left and similar is true for all other directions
    private boolean canMove(int currPos, int targetPos, int dir){
        if(dir==0) {        // trying to move right
            return canRight[currPos] && canLeft[targetPos];
        } else if(dir==1) { // trying to move left
            return canLeft[currPos] && canRight[targetPos];
        } else if(dir==2) { // up
            return canUp[currPos] && canDown[targetPos];
        } else if(dir==3) { // down
            return canDown[currPos] && canUp[targetPos];
        }
        return false;
    }
}
