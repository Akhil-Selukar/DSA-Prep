package org.akhil;

import java.util.PriorityQueue;

public class Solution {
    // Solution 1 - Using priorityQueue
    // TC -> O(N^2*logN) - Each element in grid is accessed twice during iterations. First while adding in priority queue and second while assigning sorted value (i.e. polled value at index (i, j)), hence N^2. The logN component is because of priority queue, insertion and extraction in priority queue is O(logN) operation.
    // SC -> O(N) - At max N elements can be stored in priority queue in worst case (while traversing diagonal where i == j). Hence space complexity is O(N).

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)-> b-a);       // sort in descending order

        // traverse diagonals in bottom triangle
        for(int i=n-1; i>=0; i--){
            int row = i;
            int col = 0;

            // add diagonal elements in priority queue
            while(row < n){
                queue.offer(grid[row][col]);
                row++;
                col++;
            }

            // update grid with sorted values
            row = i;
            col = 0;
            while(row < n){
                grid[row][col] = queue.poll();
                row++;
                col++;
            }
        }

        // assign priority queue to sort in ascending order
        queue = new PriorityQueue<>((a,b)-> a-b);

        // traverse diagonal in upper triangle
        for(int i=1; i<n; i++){
            int row = 0;
            int col = i;

            while(col < n){
                queue.offer(grid[row][col]);
                row++;
                col++;
            }

            row = 0;
            col = i;
            while(col < n){
                grid[row][col] = queue.poll();
                row++;
                col++;
            }
        }

        return grid;
    }
}
