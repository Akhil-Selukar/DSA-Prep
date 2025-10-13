package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] words = {"abba","baba","bbaa","cd","cd"};

        Solution solution = new Solution();
        System.out.println(solution.removeAnagrams(words));
    }
}