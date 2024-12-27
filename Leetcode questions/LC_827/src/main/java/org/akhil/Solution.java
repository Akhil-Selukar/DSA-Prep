package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
    public int largestIsland(int[][] grid) {
        DisjointSet ds = new DisjointSet(grid.length * grid.length);

        // Step-1 : Populate disjoint set and create groups of connected nodes.
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                if(grid[i][j] == 0){
                    continue;
                }

                for(int[] direction:directions){
                    int adjRow = i+direction[0];
                    int adjCol = j+direction[1];

                    if(isValid(adjRow, adjCol, grid.length) && grid[adjRow][adjCol] == 1){
                        int nodeValue = i * grid.length + j;
                        int adjNodeValue = adjRow * grid.length + adjCol;

                        ds.unionBySize(nodeValue, adjNodeValue);
                    }
                }
            }
        }

        // Step-2 : Try replacing 0 with 1 for cells
        int maxIslandSize = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                Set<Integer> connectedComponents = new HashSet<>();
                for(int[] direction:directions){
                    int adjRow = i+direction[0];
                    int adjCol = j+direction[1];

                    if(isValid(adjRow, adjCol, grid.length) && grid[adjRow][adjCol]==1){
                        int adjNodeValue = adjRow * grid.length + adjCol;
                        connectedComponents.add(ds.findParent(adjNodeValue));
                    }
                }
                // calculate size of island formed in this iteration
                int islandSize = 0;
                for(int parent:connectedComponents){
                    islandSize = islandSize + ds.size.get(parent);
                }
                maxIslandSize = Math.max(maxIslandSize, islandSize+1);
            }
        }

        // step 3 (edge case) - in case of all cells are already 1 and no cell is changed from 0 to 1,
        // then above calculation will not happen and max will always remain 0.
        for(int nodeVal=0; nodeVal<grid.length*grid.length; nodeVal++){
            maxIslandSize = Math.max(maxIslandSize, ds.size.get(ds.findParent(nodeVal)));
        }

        return maxIslandSize;
    }

    private boolean isValid(int row, int col, int sideLength){
        return (row>=0 && col>=0 && row<sideLength && col<sideLength);
    }
}
