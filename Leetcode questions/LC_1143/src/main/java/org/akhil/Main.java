package org.akhil;

public class Main {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }
}