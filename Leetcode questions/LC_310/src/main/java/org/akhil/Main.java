package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};

        Solution solution = new Solution();
        System.out.println(solution.findMinHeightTrees(n, edges));
    }
}