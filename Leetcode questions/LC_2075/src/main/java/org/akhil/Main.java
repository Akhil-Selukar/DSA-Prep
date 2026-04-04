package org.akhil;

public class Main {
    public static void main(String[] args) {
        String encodedText = "iveo    eed   l te   olc";
        int rows = 4;

        Solution solution = new Solution();
        System.out.println(solution.decodeCiphertext(encodedText, rows));
    }
}