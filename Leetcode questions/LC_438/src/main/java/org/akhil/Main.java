package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        Solution solution = new Solution();
        System.out.println(solution.findAnagrams(s, p));
    }
}