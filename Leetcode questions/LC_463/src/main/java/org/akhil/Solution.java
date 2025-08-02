package org.akhil;

public class Solution {

    // Solution - 1
    // O(M*N)/O(1)
    private final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int connectedLandCount = 0;
                    for(int[] direction:directions){
                        int newI = i + direction[0];
                        int newJ = j + direction[1];

                        if(newI >=0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == 1){
                            connectedLandCount++;
                        }
                    }
                    perimeter = perimeter + (4-connectedLandCount);
                }
            }
        }
        return perimeter;
    }
}
