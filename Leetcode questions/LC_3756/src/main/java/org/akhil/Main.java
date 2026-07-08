package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "10203004";
        int[][] queries = {{0,7},{1,3},{4,6}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sumAndMultiply(s, queries)));
    }
}