package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        Solution solution = new Solution();

        System.out.println(solution.minCostConnectPoints(points));
    }
}