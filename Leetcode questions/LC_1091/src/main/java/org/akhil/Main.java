package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};   // 4
        int[][] grid = {{0,1,1,1,1,1,1,1},{0,1,1,0,0,0,0,0},{0,1,0,1,1,1,1,0},{0,1,0,1,1,1,1,0},{0,1,1,0,0,1,1,0},{0,1,1,1,1,0,1,0},{0,0,0,0,0,1,1,0},{1,1,1,1,1,1,1,0}};   //25

//        Solution solution = new Solution();
//        System.out.println(solution.shortestPathBinaryMatrix(grid));

        ImprovedSolution sol = new ImprovedSolution();
        System.out.println(sol.shortestPathBinaryMatrix(grid));
    }
}