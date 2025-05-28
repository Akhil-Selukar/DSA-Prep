package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
//        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
//        int k = 2;

        int[][] edges1 = {{2,1},{7,3},{0,4},{7,5},{2,6},{0,2},{0,7}};
        int[][] edges2 = {{3,0},{1,2},{5,1},{6,3},{9,4},{5,6},{7,5},{9,7},{8,9}};
        int k = 7;

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.maxTargetNodes(edges1, edges2, k)));
    }
}