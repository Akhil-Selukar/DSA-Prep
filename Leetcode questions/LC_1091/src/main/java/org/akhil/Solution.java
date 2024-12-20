package org.akhil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private class Pair {
        private int distance;
        private int x;
        private int y;

        public Pair(int distance, int x, int y) {
            this.distance = distance;
            this.x = x;
            this.y = y;
        }
    }

    int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        // edge cases
        if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0) {
            return -1;
        } else if (grid.length == 1) {
            return 1;
        }

        // initialize and fill the dist array.
        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] subArr : dist) {
            Arrays.fill(subArr, 999999);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 0));     // starting point (upper-left cell (0, 0))
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            int currentDistance = temp.distance;
            int currentX = temp.x;
            int currentY = temp.y;

            for(int[] direction:directions){
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];
                int newDistance = currentDistance+1;

                if(checkValid(newX, newY, newDistance, grid, dist)){
                    queue.offer(new Pair(newDistance, newX, newY));
                    if(newX == grid.length-1 && newY == grid.length-1){
                        return newDistance+1;
                    }
                }
            }
        }
        return -1;
    }

    private boolean checkValid(int x, int y, int newDist, int[][] grid, int[][] dist) {
        return (x >= 0 && y >= 0 && x < grid.length && y < grid.length && (grid[x][y] == 0) && newDist < dist[x][y]);
    }
}
