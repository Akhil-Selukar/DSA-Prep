package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String s1 = "great";
//        String s2 = "rgeat";

        String s1 = "abcde";
        String s2 = "caebd";

        Solution solution = new Solution();
        System.out.println(solution.isScramble(s1, s2));
    }
}