package org.akhil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};

        Solution solution = new Solution();
        List<List<Integer>> result = solution.palindromePairs(words);

        System.out.println(result);
    }
}