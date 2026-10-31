package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1,1},{1,2,1},{0,2,3}};
        String labels = "aab";
        int k = 1;

        Solution solution = new Solution();
        System.out.println(solution.shortestPath(n, edges, labels, k));
    }
}