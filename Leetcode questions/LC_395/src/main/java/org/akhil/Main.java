package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;

//        String s = "aaabb";
//        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.longestSubstring(s, k));
    }
}