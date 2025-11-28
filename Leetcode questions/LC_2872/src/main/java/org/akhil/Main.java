package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,2},{1,2},{1,3},{2,4}};
        int[] values = {1,8,1,4,4};
        int k = 6;

        Solution solution = new Solution();
        System.out.println(solution.maxKDivisibleComponents(n,edges, values, k));
    }
}