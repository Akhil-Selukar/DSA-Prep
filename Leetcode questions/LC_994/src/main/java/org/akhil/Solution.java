package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private class Pair{
        int x;
        int y;
        int t;

        public Pair(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int maxTime = 0;
        int freshCount = 0;
        int newlyRottenCount = 0;

        // initialize queue for starting condition.
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i,j,0)); // time is 0 because this is initial condition so this orange is already in rotten stage.
                } else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        // start BFS
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int tempX = temp.x;
            int tempY = temp.y;
            int tempT = temp.t;

            maxTime = Math.max(maxTime, tempT);

            for(int[] direction: directions){
                int newX = tempX + direction[0];
                int newY = tempY + direction[1];

                if(newX >=0 && newY >=0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1){
                    grid[newX][newY] = 2;
                    queue.add(new Pair(newX, newY, tempT+1));
                    newlyRottenCount++;
                }
            }
        }

        if(newlyRottenCount == freshCount){
            return maxTime;
        } else {
            return -1;
        }
    }
}
