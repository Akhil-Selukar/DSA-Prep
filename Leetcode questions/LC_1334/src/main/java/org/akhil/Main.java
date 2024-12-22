package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int noOfCities = 4;
//        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
//        int distanceThreshold = 4;

        int noOfCities = 5;
        int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold = 2;

        Solution solution = new Solution();
        System.out.println(solution.findTheCity(noOfCities, edges, distanceThreshold));
    }
}