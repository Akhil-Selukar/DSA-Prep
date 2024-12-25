package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int noOfNodes = 6;
//        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        int noOfNodes = 4;
        int[][] connections = {{0,1},{0,2},{1,2}};

        Solution sol = new Solution();

        System.out.println(sol.makeConnected(noOfNodes, connections));
    }
}