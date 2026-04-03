package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] robots = {10,2};
        int[] distance = {5,1};
        int[] walls = {5,2,7};

        Solution solution = new Solution();
        System.out.println(solution.maxWalls(robots, distance, walls));
    }
}