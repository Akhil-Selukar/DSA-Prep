package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{5,2,4},{3,0,5},{0,7,2}};
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.numberOfPaths(grid, k));
    }
}