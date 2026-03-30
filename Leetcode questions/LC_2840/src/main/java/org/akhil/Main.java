package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s1 = "abcdba";
        String s2 = "cabdab";

        Solution solution = new Solution();
        System.out.println(solution.checkStrings(s1, s2));
    }
}