package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{1}};
        Solution solution = new Solution();

        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}