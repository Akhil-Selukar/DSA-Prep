package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        Solution solution = new Solution();
        System.out.println(solution.findSubstring(s, words));
    }
}