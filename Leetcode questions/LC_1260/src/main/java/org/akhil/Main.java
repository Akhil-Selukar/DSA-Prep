package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;

        Solution solution = new Solution();
        System.out.println(solution.shiftGrid(grid, k));
    }
}