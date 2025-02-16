package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

//        String s = "axc";
//        String t = "ahbgdc";

        Solution solution = new Solution();
        System.out.println(solution.isSubsequence(s, t));
    }
}