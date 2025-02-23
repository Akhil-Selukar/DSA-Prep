package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59","00:00");

        Solution solution = new Solution();
        System.out.println(solution.findMinDifference(timePoints));
    }
}