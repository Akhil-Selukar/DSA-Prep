package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";

        String s = "rat";
        String t = "car";

        Solution solution = new Solution();
        System.out.println(solution.isAnagram(s, t));
    }
}