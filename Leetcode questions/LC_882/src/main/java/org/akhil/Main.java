package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] edges = {{0,1,10},{0,2,1},{1,2,2}};
        int maxMoves = 6, n = 3;

        Solution solution = new Solution();
        System.out.println(solution.reachableNodes(edges, maxMoves, n));
    }
}