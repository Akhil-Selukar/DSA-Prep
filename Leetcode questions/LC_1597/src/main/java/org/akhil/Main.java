package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};

        Solution solution = new Solution();
        System.out.println(solution.maxNumEdgesToRemove(n, edges));
    }
}