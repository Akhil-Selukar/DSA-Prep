package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s1 = "parker";
        String s2 = "morris";
        String baseStr = "parser";

        Solution solution = new Solution();
        System.out.println(solution.smallestEquivalentString(s1, s2, baseStr));
    }
}