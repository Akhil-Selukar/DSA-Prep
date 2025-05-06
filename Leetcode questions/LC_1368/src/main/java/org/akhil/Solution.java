package org.akhil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution {

    // Solution 1 - using priority queue (Memory limit exceed)
    // Time Complexity: O(R * C * log(R * C))
    // Space Complexity: O(R * C)
//    int[][] directions = {{0,1,1}, {0,-1,2}, {1,0,3}, {-1,0,4}};  //[dx, dy, representation in question]
//    public int minCost(int[][] grid) {
//        int r = grid.length;
//        int c = grid[0].length;
//
//        int[][] visited = new int[r][c];
//        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0]-b[0]);
//        queue.offer(new int[]{0, 0, 0});    //[cost, row, col] starting from (0,0) at as we have not moved yet so cost is 0.
//        visited[0][0] = 1;
//
//        while(!queue.isEmpty()){
//            int[] currPosition = queue.poll();
//            int currCost = currPosition[0];
//            int currRow = currPosition[1];
//            int currCol = currPosition[2];
//
//            // If we reach to bottom-right corner.
//            if(currRow == r-1 && currCol == c-1){
//                return currCost;
//            }
//
//            visited[currRow][currCol] = 1;
//
//            for(int[] direction:directions){
//                int dx = direction[0];
//                int dy = direction[1];
//                int directionVal = direction[2];
//
//                int newCol = currCol + dy;
//                int newRow = currRow + dx;
//
//                if(newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && visited[newRow][newCol] != 1){
//                    int newCost = currCost;             // every time when we check for new neighbour we need to calculate cost to move till that neighbour again with respect to current position.
//                    if(grid[currRow][currCol] != directionVal){         // if direction we are moving is not equal to the direction mentioned in grid then cost will increase.
//                        newCost = newCost + 1;
//                    }
//                    queue.offer(new int[]{newCost, newRow, newCol});
//                }
//            }
//        }
//
//        return -1;  // unreachable code as we will reach to (r-1, c-1) in every case.
//    }


    // Solution 2 - using deque
    // Time Complexity: O(R * C)
    // Space Complexity: O(R * C)
    int[][] directions = {{0,1,1}, {0,-1,2}, {1,0,3}, {-1,0,4}};  //[dx, dy, representation in question]
    public int minCost(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visited = new boolean[r][c];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});    //[cost, row, col] starting from (0,0) at as we have not moved yet so cost is 0.
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] currPosition = queue.pollFirst();
            int currCost = currPosition[0];
            int currRow = currPosition[1];
            int currCol = currPosition[2];

            // If we reach to bottom-right corner.
            if(currRow == r-1 && currCol == c-1){
                return currCost;
            }

            visited[currRow][currCol] = true;

            for(int[] direction:directions){
                int directionVal = direction[2];

                int newCol = currCol + direction[1];
                int newRow = currRow + direction[0];

                if(newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && !visited[newRow][newCol]){
                    if(grid[currRow][currCol] != directionVal){         // if direction we are moving is not equal to the direction mentioned in grid then cost will increase.
                        queue.addLast(new int[]{currCost+1, newRow, newCol});
                    } else {
                        queue.addFirst(new int[]{currCost, newRow, newCol});
                    }
                }
            }
        }

        return -1;  // unreachable code as we will reach to (r-1, c-1) in every case.
    }
}
