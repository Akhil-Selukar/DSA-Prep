package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] words = {"ab","ty","yt","lc","cl","ab"};
//        String[] words = {"aa","aa"};

        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(words));
    }
}