package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String s = "1001010";
//        int k = 5;

//        String s = "00101001";
//        int k = 1;

        String s = "1111000100000111010011100011110000000010111011111111101110000111110110000101011101001101100011110010" +
                "01011001010011010000011111101001101000000101101001110110000111101011000101";
        int k = 11713332;

        Solution solution = new Solution();
        System.out.println(solution.longestSubsequence(s, k));
    }
}