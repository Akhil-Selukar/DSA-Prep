package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{2,4,3},{6,5,2}};

        Solution solution = new Solution();
        System.out.println(solution.hasValidPath(grid));
    }
}