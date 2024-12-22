package org.dsaprep;

public class Solution {

    public int[][] shortestDistance(int[][] grid) {
        // here in question they are using -1 to represent no edge instead of infinity hence we can tweak the algorithm and modify the given matrix as per
        // our convenience and then before returning bring back the matrix in original shape.

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == -1){
                    grid[i][j] = (int)1e9;
                }
//                if(i == j){
//                    grid[i][j] = 0;
//                }
            }
        }

        // Actual algorithm
        for(int k=0; k<grid.length; k++){
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid.length; j++){
                    grid[i][j] = Math.min(grid[i][j], grid[i][k]+grid[k][j]);
                }
            }
        }

        // If asked to check for negative cycle
        for(int i=0; i<grid.length; i++){
            if(grid[i][i] < 0){
                System.out.println("Negative cycle detected..!!");
                return new int[][] {{-1}};
            }
        }

        // converting matrix back to original shape
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == (int)1e9){
                    grid[i][j] = -1;
                }
            }
        }
        return grid;
    }
}
