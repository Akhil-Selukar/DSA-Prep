package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};

        Solution solution = new Solution();
        System.out.println(solution.findCriticalAndPseudoCriticalEdges(n, edges));
    }
}