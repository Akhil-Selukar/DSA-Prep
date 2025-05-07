package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] moveTime = {{0,4},{4,4}};

        Solution solution = new Solution();
        System.out.println(solution.minTimeToReach(moveTime));
    }
}