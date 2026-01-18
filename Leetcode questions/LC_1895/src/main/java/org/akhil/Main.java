package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};

        Solution solution = new Solution();
        System.out.println(solution.largestMagicSquare(grid));
    }
}