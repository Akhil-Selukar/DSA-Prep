package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";

        Solution solution = new Solution();
        System.out.println(solution.removeOccurrences(s, part));
    }
}