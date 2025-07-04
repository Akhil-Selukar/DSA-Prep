package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        Solution solution = new Solution();
        System.out.println(solution.fullJustify(words, maxWidth));
    }
}