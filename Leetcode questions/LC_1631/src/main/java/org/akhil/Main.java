package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] grid = {{1,2,2},{3,8,2},{5,3,5}};
        int[][] grid = {{1,1000000}};

        Solution solution = new Solution();
        System.out.println(solution.minimumEffortPath(grid));
    }
}