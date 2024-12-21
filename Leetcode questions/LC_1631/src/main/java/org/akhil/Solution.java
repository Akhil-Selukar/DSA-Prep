package org.akhil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int[][] dist = new int[heights.length][heights[0].length];

        for(int[] arr:dist){
            Arrays.fill(arr, (int)1e9);         // (int)'1e9' represents integer value of 10^9
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y)->x[0]-y[0]);

        queue.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int distance = node[0];
            int x = node[1];
            int y = node[2];

            if(x == heights.length-1 && y == heights[0].length-1){
                return distance;
            }

            for(int[] direction:directions){
                int newX = x+direction[0];
                int newY = y+direction[1];

                if(newX>=0 && newY>=0 && newX<heights.length && newY<heights[0].length){
                    int absoluteDistance = Math.abs(heights[newX][newY] - heights[x][y]);
                    int newEfforts = Math.max(absoluteDistance, distance);

                    if(newEfforts < dist[newX][newY]){
                        dist[newX][newY] = newEfforts;
                        queue.offer(new int[]{newEfforts, newX, newY});
                    }
                }
            }
        }
        return 0;
    }
}
