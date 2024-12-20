package org.akhil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ImprovedSolution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // edge cases
        if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0) {
            return -1;
        } else if (grid.length == 1) {
            return 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});     // starting point (upper-left cell (0, 0))
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int currentDistance = temp[0];
            int currentX = temp[1];
            int currentY = temp[2];

            for (int newX = currentX - 1; newX <= currentX + 1; newX++) {
                for (int newY = currentY - 1; newY <= currentY + 1; newY++) {
                    if (newX == grid.length - 1 && newY == grid.length - 1) {
                        return currentDistance + 2;
                    }else if(checkValid(newX, newY, currentDistance+1, grid)) {
                        queue.offer(new int[]{currentDistance+1, newX, newY});
                        grid[newX][newY] = 1;
                    }
                }
            }
        }
        return -1;
    }

    private boolean checkValid(int x, int y, int[][] grid) {
        return (x >= 0 && y >= 0 && x < grid.length && y < grid.length && (grid[x][y] == 0));
    }
}
