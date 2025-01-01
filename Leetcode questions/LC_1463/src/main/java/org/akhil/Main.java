package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};

        Solution solution = new Solution();
        System.out.println(solution.cherryPickup(grid));
    }
}