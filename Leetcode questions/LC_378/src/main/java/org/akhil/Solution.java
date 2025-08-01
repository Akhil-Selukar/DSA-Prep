package org.akhil;

import java.util.PriorityQueue;

public class Solution {
    // Solution 1 - Bruteforce
    // O(N^2 logN)/O(N)
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->a-b);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                queue.offer(matrix[i][j]);
            }
        }

        while(k>1){
            queue.poll();
            k--;
        }

        return queue.poll();
    }
}
