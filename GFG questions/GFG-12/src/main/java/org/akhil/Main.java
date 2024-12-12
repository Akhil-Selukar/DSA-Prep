package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int ed = 8, vertices = 7;
        int[][] edges = {{0,1,2},{4,0,3},{4,2,1},{6,4,2},{6,5,3},{5,4,1},{1,3,1},{2,3,3}};
        Solution solution = new Solution();
        int[] result = solution.shortestPath(ed, vertices, edges);

        System.out.println(Arrays.toString(result));
    }
}