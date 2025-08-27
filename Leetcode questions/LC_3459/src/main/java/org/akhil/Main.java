package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{2,2,2,2,2},{2,0,2,2,0},{2,0,1,1,0},{1,0,2,2,2},{2,0,0,2,2}};

        Solution solution = new Solution();
        System.out.println(solution.lenOfVDiagonal(grid));
    }
}