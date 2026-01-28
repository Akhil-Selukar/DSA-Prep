package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,3,3},{2,5,4},{4,3,5}};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.minCost(grid, k));
    }
}