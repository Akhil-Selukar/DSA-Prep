package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] result = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();    // [i, j, distance];

        // initializing the queue and visited array.
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        // BFS
        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            int i = temp[0];
            int j = temp[1];
            int distance = temp[2];
            result[i][j] = distance;

            for(int[] direction:directions){
                int newI = i + direction[0];
                int newJ = j + direction[1];

                if(newI >=0 && newJ >=0 && newI < mat.length && newJ < mat[0].length && !visited[newI][newJ]){
                    if(mat[newI][newJ] == 1){
                        result[newI][newJ] = distance+1;
                    }
                    queue.offer(new int[]{newI, newJ, distance+1});
                    visited[newI][newJ] = true;
                }
            }
        }
        return result;
    }
}
