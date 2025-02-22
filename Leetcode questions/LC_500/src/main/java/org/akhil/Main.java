package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findWords(words)));
    }
}