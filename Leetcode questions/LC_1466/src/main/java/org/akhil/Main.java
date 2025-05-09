package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};

        Solution solution = new Solution();

        System.out.println(solution.minReorder(n, connections));
    }
}