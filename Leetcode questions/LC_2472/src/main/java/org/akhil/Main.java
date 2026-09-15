package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "abaccdbbd";
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.maxPalindromes(s, k));
    }
}