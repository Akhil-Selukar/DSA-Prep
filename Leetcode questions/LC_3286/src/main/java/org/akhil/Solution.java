package org.akhil;

import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        // convert list to 2D array for ease
        int rows = grid.size();
        int cols = grid.get(0).size();

        int[][] arr = new int[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int val = grid.get(i).get(j);
                arr[i][j] = val;
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->Integer.compare(a[0],b[0]));  // [healthRequired, row, col]
        queue.offer(new int[]{arr[0][0], 0, 0});        // starting point and health consumed at starting point
        arr[0][0] = Integer.MAX_VALUE;      // to mark it as visited (while exploring paths we are subtracting this value from health we have and if the result is -ve we are skipping that path. So max value here means -ve remaining health

        while(!queue.isEmpty()){
            int[] polled = queue.poll();

            int healthReq = polled[0];
            int row = polled[1];
            int col = polled[2];

            // if this is destination then we can reach till here
            if(row == rows-1 && col == cols-1){
                return true;
            }

            // explore all 4 directions
            for(int[] direction:directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || health-arr[newRow][newCol] <= 0){
                    continue;   // either cell is invalid or we dont have enough health to go to that cell then skip that path itself we can not move ahead with it.
                }

                int newHealthReq = healthReq + arr[newRow][newCol];     // i.e. to reach to new cell from (0,0) we will consume this much health
                if(newHealthReq < health) {
                    queue.offer(new int[]{newHealthReq, newRow, newCol});
                }
                arr[newRow][newCol] = Integer.MAX_VALUE;    // to mark it as visited.

            }
        }

        return false;
    }
}
