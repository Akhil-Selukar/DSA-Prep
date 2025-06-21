package org.akhil;

public class Main {
    public static void main(String[] args) {
        String word = "aabcaba";
        int k = 0;

        Solution solution = new Solution();
        System.out.println(solution.minimumDeletions(word, k));
    }
}