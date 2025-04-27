package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.sumOfDistancesInTree(n, edges)));
    }
}