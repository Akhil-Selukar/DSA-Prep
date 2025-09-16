package org.akhil;

public class Main {
    public static void main(String[] args) {
        String text = "hello world";
        String brokenLetters = "ad";

        Solution solution = new Solution();
        System.out.println(solution.canBeTypedWords(text, brokenLetters));
    }
}