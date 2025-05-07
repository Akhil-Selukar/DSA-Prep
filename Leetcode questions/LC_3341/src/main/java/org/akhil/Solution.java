package org.akhil;

import java.util.PriorityQueue;

public class Solution {

    // Solution - Using Dijkstra's algorithm (O(R*C * log(R*C))/O(R*C))
    // BFS (0-1 BFS) is not possible here (it is possible only when the edge weights are same like in question LC-2290 or LC-1368
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int minTimeToReach(int[][] moveTime) {
        int r = moveTime.length;
        int c = moveTime[0].length;
        boolean[][] visited = new boolean[r][c];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        queue.offer(new int[]{0,0,0});      // starting from (0,0) and at start time will be 0 sce. [time, row, col];
//        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] polled = queue.poll();

            int currTime = polled[0];
            int currRow = polled[1];
            int currCol = polled[2];

            // without below continue condition it will give TLE
            if (visited[currRow][currCol]) { // Optimization: Skip already visited cells
                continue;
            }

            visited[currRow][currCol] = true;

            if(currRow == r-1 && currCol == c-1){
                return currTime;
            }

            for(int[] direction:directions){
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];

                if(newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && !visited[newRow][newCol]){
                    int newTime = Math.max(currTime, moveTime[newRow][newCol]);
                    queue.offer(new int[]{newTime + 1, newRow, newCol});        // +1 in time for movement.
                }
            }
        }

        return -1;
    }
}
