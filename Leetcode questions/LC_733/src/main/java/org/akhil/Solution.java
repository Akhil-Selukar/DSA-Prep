package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int initialColor = image[sr][sc];
        bfs(image, sr, sc, visited, initialColor, color);

        return image;
    }

    private void bfs(int[][] image, int px, int py, boolean[][] visited, int initialColor, int targetColor) {
        Queue<int[]> queue = new LinkedList<>();
        visited[px][py] = true;
        image[px][py] = targetColor;
        queue.offer(new int[]{px, py});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempX = temp[0];
            int tempY = temp[1];

//            for(int[] direction:directions){
//                int newX = tempX + direction[0];
//                int newY = tempY + direction[1];
//
//                if (newX >= 0 && newY >= 0 && newX < image.length && newY < image[0].length
//                        && image[newX][newY] == initialColor && !visited[newX][newY]) {
//                    queue.offer(new int[]{newX, newY});
//                    image[newX][newY] = targetColor;
//                    visited[newX][newY] = true;
//                }
//            }

            // left
            if (tempX - 1 >= 0 && image[tempX - 1][tempY] == initialColor && !visited[tempX - 1][tempY]) {
                queue.offer(new int[]{tempX - 1, tempY});
                image[tempX - 1][tempY] = targetColor;
                visited[tempX - 1][tempY] = true;
            }

            // right
            if (tempX + 1 < image.length && image[tempX + 1][tempY] == initialColor && !visited[tempX + 1][tempY]) {
                queue.offer(new int[]{tempX + 1, tempY});
                image[tempX + 1][tempY] = targetColor;
                visited[tempX + 1][tempY] = true;
            }

            // up
            if (tempY - 1 >= 0 && image[tempX][tempY - 1] == initialColor && !visited[tempX][tempY - 1]) {
                queue.offer(new int[]{tempX, tempY - 1});
                image[tempX][tempY - 1] = targetColor;
                visited[tempX][tempY - 1] = true;
            }

            // down
            if (tempY + 1 < image[0].length && image[tempX][tempY + 1] == initialColor && !visited[tempX][tempY + 1]) {
                queue.offer(new int[]{tempX, tempY + 1});
                image[tempX][tempY + 1] = targetColor;
                visited[tempX][tempY + 1] = true;
            }
        }
    }
}
