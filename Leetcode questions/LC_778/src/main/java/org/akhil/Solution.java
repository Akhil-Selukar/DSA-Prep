package org.akhil;

import java.util.PriorityQueue;

public class Solution {
    // O(M*N*log(M*N))/O(M*N)
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        boolean[][] visited = new boolean[n][m];

        // start from index (0,0)
        queue.offer(new int[]{grid[0][0], 0, 0});       // [minElevation, row, col]

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            int elevation = polled[0];
            int row = polled[1];
            int col = polled[2];
            visited[row][col] = true;

            // we reached the destination
            if(row == n-1 && col == m-1){
                return elevation;
            }

            for(int[] direction:directions){
                int newRow = row+direction[0];
                int newCol = col+direction[1];

                if(newRow >=0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]){
                    queue.offer(new int[]{Math.max(elevation, grid[newRow][newCol]), newRow, newCol});
                }
            }
        }

        return -1;
    }
}
