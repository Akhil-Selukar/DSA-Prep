package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String s = "()())()";
        String s = "(a)())()";
//        String s = ")(f";
//        String s = ")(";

        Solution solution = new Solution();
        System.out.println(solution.removeInvalidParentheses(s));
    }
}