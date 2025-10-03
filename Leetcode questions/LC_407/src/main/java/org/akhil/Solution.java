package org.akhil;

// Here it is obvious that the boundary cells will not be able to hold any water, So we will have to check for all cell inside the boundary.
// Now at any cell the amount of water that can be trapped in it will be equal to the difference between height of that cell and the minimum
// height of all 4 neighbors. So This is what we will be using to calculate water which can be trapped in each cell.
// Now another scenario is something like if a cell has height 2 then the minimum of all 4 neighbors is 4 so that cell can hold 2 units of water
// but neighbour having height 4 can also store water of 2 units then in that case the total water which can be stored in cell with
// height 2 will be 4 and not 2. To handle this we will start from boundary and go inward storing water and keep on updating the height
// with water instead of just simple height of cell because inner cell's capacity depends on outer cells height plus water it can store.

import java.util.PriorityQueue;

public class Solution {

    // TC -> O(M*N * Log(M*N))
    // SC -> O(M*N)
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        // don't want to visit already visited cells hence a visited array
        boolean[][] visited = new boolean[m][n];
        // PriorityQueue to store boundaries (min heap)
        PriorityQueue<int[]> boundary = new PriorityQueue<>((a, b)->a[0]-b[0]);

        // add top and bottom boundaries
        for(int i=0; i<n; i++){
            // top row
            boundary.offer(new int[]{heightMap[0][i], 0, i});
            visited[0][i] = true;
            // bottom row
            boundary.offer(new int[]{heightMap[m-1][i], m-1, i});
            visited[m-1][i] = true;
        }

        // add left and right boundaries
        for(int i=0; i<m; i++){
            // left column
            boundary.offer(new int[]{heightMap[i][0], i, 0});
            visited[i][0] = true;
            // right column
            boundary.offer(new int[]{heightMap[i][n-1], i, n-1});
            visited[i][n-1] = true;
        }

        int waterTrapped = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!boundary.isEmpty()){
            int[] currCell = boundary.poll();
            int currHeight = currCell[0];
            int row = currCell[1];
            int col = currCell[2];

            for(int[] direction:directions){
                int rowNew = row + direction[0];
                int colNew = col + direction[1];

                if(rowNew < m && rowNew >=0 && colNew < n && colNew >=0 && !visited[rowNew][colNew]){
                    waterTrapped = waterTrapped + Math.max((currHeight - heightMap[rowNew][colNew]), 0);
                    boundary.offer(new int[]{Math.max(currHeight, heightMap[rowNew][colNew]), rowNew, colNew });
                    visited[rowNew][colNew] = true;
                }
            }
        }

        return waterTrapped;
    }
}
