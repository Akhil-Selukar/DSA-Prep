package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int n = 3;
//        int[][] redEdges = {{0,1},{1,2}};
//        int[][] blueEdges = {};

        int n = 6;
        int[][] redEdges = {{0,1}, {5,2}};
        int[][] blueEdges = {{0,2}, {1,2}, {1,3}, {2,4}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(n, redEdges, blueEdges)));
    }
}