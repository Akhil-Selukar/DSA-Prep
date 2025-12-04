package org.akhil;

public class Main {
    public static void main(String[] args) {
        String directions = "RLRSLL";

        Solution solution = new Solution();
        System.out.println(solution.countCollisions(directions));
    }
}