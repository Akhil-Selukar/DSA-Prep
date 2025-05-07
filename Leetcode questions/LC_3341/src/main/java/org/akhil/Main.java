package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] moveTime = {{0,4},{4,4}};
        int[][] moveTime = {{0,0,0},{0,0,0}};

        Solution solution = new Solution();
        System.out.println(solution.minTimeToReach(moveTime));
    }
}