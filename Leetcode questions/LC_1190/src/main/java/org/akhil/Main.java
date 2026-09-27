package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";

        Solution solution = new Solution();
        System.out.println(solution.reverseParentheses(s));
    }
}