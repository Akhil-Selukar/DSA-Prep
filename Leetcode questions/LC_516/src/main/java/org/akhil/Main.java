package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "bbcbab";
//        String s = "bbbab";
//        String s = "bb";
//        String s = "bc";

        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq(s));
    }
}