package org.akhil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = List.of("cat","cats","and","sand","dog");

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));
    }
}