package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1,4,0},{1,2,3,0},{0,2,1,0}};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxStability(n, edges, k));
    }
}