package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String s = "00110110";
//        String s = "0110";
        String s = "00110";
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.hasAllCodes(s, k));
    }
}