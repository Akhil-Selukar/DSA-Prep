package org.akhil;

import java.util.PriorityQueue;

public class Solution {

    // Solution - using Dijkstra's algorithm (O(R*C log(R*C))/O(R*C))
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minTimeToReach(int[][] moveTime) {
        int r = moveTime.length;
        int c = moveTime[0].length;

        boolean[][] visited = new boolean[r][c];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        queue.offer(new int[]{0,0,0,2});      // [time, row, col, stepTime]     // initially step time is 2 because we want to start with 1 (see inside loop)

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int currTime = curr[0];
            int currRow = curr[1];
            int currCol = curr[2];
            int currStepTime = curr[3];

            if(visited[currRow][currCol]){
                continue;
            }

            if(currRow == r-1 && currCol == c-1){
                return currTime;
            }

            visited[currRow][currCol] = true;

            for(int[] direction:directions){
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];

                if(newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && !visited[newRow][newCol]){
                    int newTime = Math.max(currTime, moveTime[newRow][newCol]);
                    int newStepTime = (currStepTime == 1) ? 2 : 1;

                    queue.offer(new int[]{newTime + newStepTime, newRow, newCol, newStepTime});
                }
            }
        }

        return -1;
    }
}
