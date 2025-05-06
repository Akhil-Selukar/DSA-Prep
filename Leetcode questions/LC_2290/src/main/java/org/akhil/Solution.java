package org.akhil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution {

    // Here time and space complexity for below solution is O(R* C * log(R*C))/O(R*C) where R is rows in grid and C is columns in grid
    // time complexity for fetching element from priority queue is log(N). In our example priority queue can at max contain (R*C) elements.

    // Solution 1 - using priority queue (More intuitive)
//    int[][] directions = {{0,+1}, {0,-1}, {+1,0}, {-1,0}};
//    public int minimumObstacles(int[][] grid) {
//        int r = grid.length;
//        int c = grid[0].length;
//
//        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
//        pQueue.offer(new int[]{grid[0][0], 0, 0});      // i.e. [minObstacles, row, col] ((0,0) is the starting point and if there is a obstacle at (0,,0) then minObstacles will be 1 or 0)
//
//        int[][] visited = new int[r][c];
//
//        while(!pQueue.isEmpty()){
//            int[] curr = pQueue.poll();
//            int currObstacles = curr[0];
//            int row = curr[1];
//            int col = curr[2];
//
//            // if we reach to bottom-right corner
//            if(row == (r-1) && col == (c-1)){
//                return currObstacles;
//            }
//
//            for(int[] direction:directions){
//                int newRow = row + direction[0];
//                int newCol = col + direction[1];
//
//                if(newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && visited[newRow][newCol] != 1){
//                    visited[newRow][newCol] = 1;
//                    int newObstacles = currObstacles + grid[newRow][newCol];
//                    pQueue.offer(new int[]{newObstacles, newRow, newCol});
//                }
//            }
//        }
//
//        return -1;      // unreachable code
//    }


    // Solution 2 - using deque (Optimized and more need minute observation and detailed understanding)
    // Time and space complexity for this solution is O(R*C)/O(R*C), as we have eliminated priority queue here hence log() part in time complexity is reduced.
    int[][] directions = {{0,+1}, {0,-1}, {+1,0}, {-1,0}};
    public int minimumObstacles(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{grid[0][0], 0, 0});      // i.e. [minObstacles, row, col] ((0,0) is the starting point and if there is a obstacle at (0,,0) then minObstacles will be 1 or 0)

        int[][] visited = new int[r][c];

        while(!dq.isEmpty()){
            int[] curr = dq.pollFirst();
            int currObstacles = curr[0];
            int row = curr[1];
            int col = curr[2];

            // if we reach to bottom-right corner
            if(row == (r-1) && col == (c-1)){
                return currObstacles;
            }

            for(int[] direction:directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && visited[newRow][newCol] != 1){
                    visited[newRow][newCol] = 1;
                    int newObstacles = currObstacles + grid[newRow][newCol];

                    if(newObstacles > currObstacles){
                        dq.addLast(new int[]{newObstacles, newRow, newCol});
                    } else {
                        dq.addFirst(new int[]{newObstacles, newRow, newCol});
                    }
                }
            }
        }

        return -1;      // unreachable code
    }
}
