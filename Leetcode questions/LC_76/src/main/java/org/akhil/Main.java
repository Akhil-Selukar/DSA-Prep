package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

//        String s = "ab";
//        String t = "b";

//        String s = "aa";
//        String t = "aa";

//        String s = "bba";
//        String t = "ab";

        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
    }
}