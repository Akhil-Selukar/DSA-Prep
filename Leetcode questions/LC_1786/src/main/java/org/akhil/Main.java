package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};

        Solution solution = new Solution();
        System.out.println(solution.countRestrictedPaths(n, edges));
    }
}