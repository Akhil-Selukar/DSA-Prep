package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] bottomLeft = {{1,1},{2,2},{1,2}};
        int[][] topRight = {{3,3},{4,4},{3,4}};

        Solution solution = new Solution();
        System.out.println(solution.largestSquareArea(bottomLeft, topRight));
    }
}