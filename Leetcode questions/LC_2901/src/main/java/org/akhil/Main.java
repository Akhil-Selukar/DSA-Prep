package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] words = {"bab","dab","cab"};
        int[] groups = {1,2,2};

        Solution solution = new Solution();
        System.out.println(solution.getWordsInLongestSubsequence(words, groups));
    }
}