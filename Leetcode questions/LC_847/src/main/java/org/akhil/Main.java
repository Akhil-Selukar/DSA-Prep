package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};

        Solution solution = new Solution();
        System.out.println(solution.shortestPathLength(graph));
    }
}