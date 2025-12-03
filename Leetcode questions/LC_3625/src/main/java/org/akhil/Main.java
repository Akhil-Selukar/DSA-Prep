package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] points = {{-3,2},{3,0},{2,3},{3,2},{2,-3}};

        Solution solution = new Solution();
        System.out.println(solution.countTrapezoids(points));
    }
}