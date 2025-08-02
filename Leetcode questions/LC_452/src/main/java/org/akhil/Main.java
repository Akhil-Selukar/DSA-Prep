package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};

        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(points));
    }
}