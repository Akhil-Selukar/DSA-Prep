package org.akhil;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // O(N^2)/O(N^2)
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int destination = n * n;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);           // as we are starting from 1
        boolean[] visited = new boolean[destination +1];      // as we dont want to visit same cell again and again. +1 because our counting in given matrix starts from 1.

        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();        // destination this many element was covered from starting point in 1 dice roll.

            for(int i=0; i<size; i++){
                int curr = queue.poll();

                if(curr == destination){
                    return level;       // we reach to the destination;
                }

                // move to next 6 possibilities
                for(int next = curr+1; next <= Math.min(curr+6, destination); next++){
                    int nextPosition =  next;

                    // Calculate board position
                    int row = (next - 1) / n;       // row in normal board (but our board is start ing from 1 hence -1 offset)
                    int col = (next - 1) % n;       // col in normal board
                    if (row % 2 == 1) // Odd rows are right-to-left
                        col = n - 1 - col;          // in case of odd row our board is arranged in reverse direction hence taking mirror

                    row = n - 1 - row;              // Convert to board coordinates as our board is mirrored entirely row wise.

                    if(board[row][col] != -1){
                        nextPosition = board[row][col];
                    }

                    if(!visited[nextPosition]){
                        visited[nextPosition] = true;
                        queue.offer(nextPosition);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
