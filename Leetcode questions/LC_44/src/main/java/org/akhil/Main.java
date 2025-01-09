package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "abcdef";
        String p = "a*d?f";

//        String s = "ab";
//        String p = "?*";

        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));
    }
}