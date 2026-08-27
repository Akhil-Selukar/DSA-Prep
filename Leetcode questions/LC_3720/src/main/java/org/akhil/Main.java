package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s = "abc";
        String target = "bba";

        Solution solution = new Solution();
        System.out.println(solution.lexGreaterPermutation(s, target));
    }
}