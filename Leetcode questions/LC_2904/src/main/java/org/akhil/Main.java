package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "100011001";
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.shortestBeautifulSubstring(s, k));
    }
}