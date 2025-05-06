package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
//        int[][] grid = {{1,1,3},{3,2,2},{1,1,4}};

        Solution solution = new Solution();
        System.out.println(solution.minCost(grid));
    }
}