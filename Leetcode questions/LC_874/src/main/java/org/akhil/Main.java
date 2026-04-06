package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};

        Solution solution = new Solution();
        System.out.println(solution.robotSim(commands, obstacles));
    }
}