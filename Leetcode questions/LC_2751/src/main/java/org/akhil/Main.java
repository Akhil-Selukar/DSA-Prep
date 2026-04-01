package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";

        Solution solution = new Solution();
        System.out.println(solution.survivedRobotsHealths(positions, healths, directions));
    }
}