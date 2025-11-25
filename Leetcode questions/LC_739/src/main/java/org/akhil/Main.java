package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
    }
}