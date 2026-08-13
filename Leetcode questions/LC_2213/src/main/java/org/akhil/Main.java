package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "babacc";
        String queryCharacters = "bcb";
        int[] queryIndices = {1,3,3};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.longestRepeating(s, queryCharacters, queryIndices)));
    }
}