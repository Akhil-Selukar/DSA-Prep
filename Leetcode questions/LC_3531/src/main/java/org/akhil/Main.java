package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] buildings = {{1,2},{2,2},{3,2},{2,1},{2,3}};

        Solution solution = new Solution();
        System.out.println(solution.countCoveredBuildings(n, buildings));
    }
}