package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};

        Solution solution = new Solution();
        System.out.println(solution.numMagicSquaresInside(grid));
    }
}