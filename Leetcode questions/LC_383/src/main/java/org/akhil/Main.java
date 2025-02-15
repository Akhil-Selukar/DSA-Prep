package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String ransomNote = "aa";
//        String magazine = "aab";

        String ransomNote = "a";
        String magazine = "b";

        Solution solution = new Solution();
        System.out.println(solution.canConstruct(ransomNote, magazine));
    }
}