package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] grid = {{1,5},{2,3}};
//        int x = 1;

        int[][] grid = {{2,4},{6,8}};
        int x = 2;

        Solution solution = new Solution();
        System.out.println(solution.minOperations(grid, x));
    }
}