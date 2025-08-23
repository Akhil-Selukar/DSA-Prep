package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] grid = {{1,0,1},{1,1,1}};
        int[][] grid = {{1,0,1,0},{0,1,0,1}};

        Solution solution = new Solution();
        System.out.println(solution.minimumSum(grid));
    }
}