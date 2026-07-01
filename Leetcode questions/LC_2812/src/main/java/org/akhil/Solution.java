package org.akhil;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    // O(N^2 log(N^2) / O(N^2)

    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {

        // convert given list to actual grid and record the cells where we have thief to start BFS
        int n = grid.size();
        int[][] safeness = new int[n][n];
        Queue<int[]> thief = new LinkedList<>();        // to store coordinates of thief [row, col]

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int val = grid.get(i).get(j);
                safeness[i][j] = val;
                if(val == 1){
                    thief.offer(new int[]{i, j});       // we will perform bfs from all this locations and update teh safeness value
                }
            }
        }

        // calculate safeness factor of each cell in grid
        // as we are using same grid (i.e. safeness) to calculate safeness index and we already have 1 at the place where thief is
        // present so we will consider safeness value of 1 for cell where thief is present and do calculations accordingly
        // as in question it is mentioned that the safeness of that cell should be 0 so from final answer we will remove 1 to adjust the difference
        while(!thief.isEmpty()){
            int[] polled = thief.poll();
            int row = polled[0];
            int col = polled[1];

            for(int[] direction:directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // if it is invalid cell or safeness value is already calculated then continue
                // if safeness is already calculated still continue because we can not get better safeness later as we are using queue/bfs.
                // try dry run
                if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || safeness[newRow][newCol] > 0){
                    continue;
                }

                safeness[newRow][newCol] = safeness[row][col] + 1;
                thief.offer(new int[]{newRow, newCol});     // BFS
            }
        }

        // calculate min safeness path (sort of Dijkstras)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));   // sorted on the basis of safeness
        pq.offer(new int[]{safeness[0][0], 0, 0});  // [safeness, row, col];
        safeness[0][0] = -1; // as this safeness is considered (marking as visited)

        while(!pq.isEmpty()){
            int[] polled = pq.poll();

            int safeVal = polled[0];
            int row = polled[1];
            int col = polled[2];

            if (row == n-1 && col == n-1){      // reached the target
                return safeVal - 1;
            }

            // if not at target then explore all directions
            for(int[] direction: directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // if invalid cell or already visited cell
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || safeness[newRow][newCol] < 0){
                    continue;
                }

                // carry forward the minimum safeness on this path
                int min = Math.min(safeVal, safeness[newRow][newCol]);
                pq.offer(new int[]{min, newRow, newCol});
                safeness[newRow][newCol] = -1;      // mark visited
            }
        }
        return 0;
    }
}
