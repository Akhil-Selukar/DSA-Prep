package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";

        Solution solution = new Solution();
        System.out.println(solution.canBeEqual(s1, s2));
    }
}