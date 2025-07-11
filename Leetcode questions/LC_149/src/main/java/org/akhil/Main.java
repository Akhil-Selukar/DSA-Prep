package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        int[][] points = {{0,1},{0,0}};
        int[][] points = {{0,0},{1,-1},{1,1}};

        Solution solution = new Solution();
        System.out.println(solution.maxPoints(points));
    }
}