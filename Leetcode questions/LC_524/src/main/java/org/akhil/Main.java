package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String s = "abpcplea";
//        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");

        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("a","b","c");

        Solution solution = new Solution();
        System.out.println(solution.findLongestWord(s, dictionary));
    }
}