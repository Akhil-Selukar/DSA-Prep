package org.akhil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

        Solution solution = new Solution();
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}