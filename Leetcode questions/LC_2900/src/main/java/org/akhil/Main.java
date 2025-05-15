package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] words = {"e","a","b"};
        int[] groups = {0,0,1};

        Solution solution = new Solution();
        System.out.println(solution.getLongestSubsequence(words, groups));
    }
}