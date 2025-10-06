package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int[][] grid = {{0,2},{1,3}};

        Solution solution = new Solution();
        System.out.println(solution.swimInWater(grid));
    }
}