package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String word1 = "bacdc";
        String word2 = "abc";

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.validSequence(word1, word2)));
    }
}