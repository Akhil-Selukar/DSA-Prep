package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxTargetNodes(edges1, edges2)));
    }
}