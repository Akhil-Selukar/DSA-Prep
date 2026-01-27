package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0,1,3},{3,1,1},{2,3,4},{0,2,2}};

        Solution solution = new Solution();
        System.out.println(solution.minCost(n, edges));
    }
}