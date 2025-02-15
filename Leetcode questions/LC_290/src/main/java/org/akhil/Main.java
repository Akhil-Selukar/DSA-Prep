package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String pattern = "abba";
//        String s = "dog cat cat dog";

//        String pattern = "abba";
//        String s = "dog cat cat fish";

        String pattern = "abba";
        String s = "dog dog dog dog";

        Solution solution = new Solution();
        System.out.println(solution.wordPattern(pattern, s));
    }
}