package org.akhil;

public class Main {
    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;

        Solution solution = new Solution();
        System.out.println(solution.minimumRecolors(blocks, k));
    }
}