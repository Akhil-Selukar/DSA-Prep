package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 11;
        int firstPlayer = 2;
        int secondPlayer = 4;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.earliestAndLatest(n, firstPlayer, secondPlayer)));
    }
}