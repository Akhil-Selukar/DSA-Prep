package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = Arrays.asList(new String[]{"leet", "code"});

//        String s = "applepenapple";
//        List<String> wordDict = Arrays.asList(new String[]{"apple","pen"});

//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList(new String[]{"cats","dog","sand","and","cat"});

//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList(new String[]{"cats","do","sand","and","cat"});

//        String s = "";
//        List<String> wordDict = Arrays.asList(new String[]{"cats","do","sand","and","cat"});

//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList(new String[]{});

        String s = "aaaaaaa";
        List<String> wordDict = Arrays.asList(new String[]{"aaaa","aaa"});

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));
    }
}