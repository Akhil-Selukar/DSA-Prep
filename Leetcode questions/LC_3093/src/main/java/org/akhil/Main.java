package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] wordsContainer = {"abcd","bcd","xbcd"};
        String[] wordsQuery = {"cd","bcd","xyz"};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.stringIndices(wordsContainer, wordsQuery)));
    }
}