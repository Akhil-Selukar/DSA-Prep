package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,4},{2,3}};

        Solution solution = new Solution();
        System.out.println(solution.canPartitionGrid(grid));
    }
}