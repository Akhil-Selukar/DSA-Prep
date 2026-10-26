package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0,2,1,0,0},{0,5,0,0,5},{0,0,1,0,0},{0,1,4,7,0},{0,2,0,0,8}};
        int k = 5;

        Solution solution = new Solution();
        System.out.println(solution.countIslands(grid, k));
    }
}