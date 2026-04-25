package org.akhil;

public class Main {
    public static void main(String[] args) {
        int side = 2;
        int[][] points = {{0,0},{0,1},{0,2},{1,2},{2,0},{2,2},{2,1}};
        int k = 5;

        Solution solution = new Solution();
        System.out.println(solution.maxDistance(side, points, k));
    }
}