package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    // Solution 1 - Using Priority Queue
    // O(M*NlogN)/O(M*N) where M is number of rows and N is number of column
//    public int deleteGreatestValue(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        List<PriorityQueue<Integer>> list = new ArrayList<>();
//
//        for(int i=0; i<rows; i++){
//            list.add(new PriorityQueue<>((a, b)->b-a));
//            for(int j=0; j<cols; j++){
//                list.get(i).offer(grid[i][j]);
//            }
//        }
//
//        int result = 0;
//
//        for(int i=0; i<cols; i++){
//            int currMax = 0;
//            for(PriorityQueue<Integer> queue: list){
//                currMax = Math.max(currMax, queue.poll());
//            }
//            result = result + currMax;
//        }
//        return result;
//    }


    // --------------------
    // Solution 2 - Without priority queue just by sorting
    //
    public int deleteGreatestValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0; i<rows; i++){
            Arrays.sort(grid[i]);
        }

        int result = 0;

        for(int i=0; i<cols; i++){
            int currMax = 0;
            for(int j=0; j<rows; j++){
                currMax = Math.max(currMax, grid[j][i]);
            }
            result = result + currMax;
        }
        return result;
    }
}
