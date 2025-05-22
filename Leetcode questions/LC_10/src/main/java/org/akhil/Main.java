package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String s = "aa";
//        String p = "a";

//        String s = "aa";
//        String p = "a*";

//        String s = "aa";
//        String p = "a.";

//        String s = "aa";
//        String p = ".a";

//        String s = "aa";
//        String p = ".*";

        String s = "ab";
        String p = ".*c";

        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));
    }
}