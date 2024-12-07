package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[3][3];

        grid[0][0]=2;
        grid[0][1]=1;
        grid[0][2]=1;
        grid[1][0]=1;
        grid[1][1]=1;
        grid[2][1]=1;
        grid[2][2]=1;

        Solution solution = new Solution();

        System.out.println(solution.orangesRotting(grid));
    }
}