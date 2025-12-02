package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] points = {{1,0},{2,0},{3,0},{2,2},{3,2}};

        Solution solution = new Solution();
        System.out.println(solution.countTrapezoids(points));
    }
}