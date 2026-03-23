package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] grid = {{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}};
        int[][] grid = {{1,-2,1},{1,-2,1},{3,-4,1}};

        Solution solution = new Solution();
        System.out.println(solution.maxProductPath(grid));
    }
}