package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int n = 8;
//        int[][] roads = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};

        int n = 5;
        int[][] roads = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};

        Solution solution = new Solution();
        System.out.println(solution.maximalNetworkRank(n, roads));
    }
}