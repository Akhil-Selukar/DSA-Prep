package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> robot = new ArrayList<>();
        robot.add(0);
        robot.add(4);
        robot.add(6);
        int[][] factory = {{2,2},{6,2}};

        Solution solution = new Solution();
        System.out.println(solution.minimumTotalDistance(robot, factory));
    }
}