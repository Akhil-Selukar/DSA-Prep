package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private class Pair{
        private int firstCoordinate;
        private int secondCoordinate;

        public Pair(int firstCoordinate, int secondCoordinate){
            this.firstCoordinate = firstCoordinate;
            this.secondCoordinate = secondCoordinate;
        }
    }

    // This solution can be improved drastically by using recursion (check submitted code on Leetcode)

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int counter = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    counter++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return counter;
    }

    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(new Pair(i, j));

        while(!queue.isEmpty()){
            Pair current = queue.poll();
            int currentRow = current.firstCoordinate;
            int currentColumn = current.secondCoordinate;

            // left side
            if(currentRow-1 >= 0 && Character.getNumericValue(grid[currentRow-1][currentColumn]) == 1 && !visited[currentRow-1][currentColumn]){
                queue.offer(new Pair(currentRow-1, currentColumn));
                visited[currentRow-1][currentColumn] = true;
            }

            // right side
            if(currentRow+1 < grid.length  && Character.getNumericValue(grid[currentRow+1][currentColumn]) == 1 && !visited[currentRow+1][currentColumn]){
                queue.offer(new Pair(currentRow+1, currentColumn));
                visited[currentRow+1][currentColumn] = true;
            }

            // vertical up
            if(currentColumn-1>=0 && Character.getNumericValue(grid[currentRow][currentColumn-1]) == 1 && !visited[currentRow][currentColumn-1]){
                queue.offer(new Pair(currentRow, currentColumn-1));
                visited[currentRow][currentColumn-1] = true;
            }

            // vertical down
            if(currentColumn+1<grid[0].length && Character.getNumericValue(grid[currentRow][currentColumn+1]) == 1 && !visited[currentRow][currentColumn+1]){
                queue.offer(new Pair(currentRow, currentColumn+1));
                visited[currentRow][currentColumn+1] = true;
            }

//            // up-left
//            if(currentColumn-1>=0 && currentRow-1>=0 && Character.getNumericValue(grid[currentRow-1][currentColumn-1]) == 1 && !visited[currentRow-1][currentColumn-1]){
//                queue.offer(new Pair(currentRow-1, currentColumn-1));
//                visited[currentRow-1][currentColumn-1] = true;
//            }
//
//            // up-right
//            if(currentColumn-1>=0 && currentRow+1<grid.length && Character.getNumericValue(grid[currentRow+1][currentColumn-1]) == 1 && !visited[currentRow+1][currentColumn-1]){
//                queue.offer(new Pair(currentRow+1, currentColumn-1));
//                visited[currentRow+1][currentColumn-1] = true;
//            }
//
//            // down-right
//            if(currentColumn+1<grid[0].length && currentRow+1<grid.length && Character.getNumericValue(grid[currentRow+1][currentColumn+1]) == 1 && !visited[currentRow+1][currentColumn+1]){
//                queue.offer(new Pair(currentRow+1, currentColumn+1));
//                visited[currentRow+1][currentColumn+1] = true;
//            }
//
//            // down-left
//            if(currentColumn+1<grid[0].length && currentRow-1>=0 && Character.getNumericValue(grid[currentRow-1][currentColumn+1]) == 1 && !visited[currentRow-1][currentColumn+1]){
//                queue.offer(new Pair(currentRow-1, currentColumn+1));
//                visited[currentRow-1][currentColumn+1] = true;
//            }
        }
    }
}


