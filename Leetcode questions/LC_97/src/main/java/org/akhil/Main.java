package org.akhil;

public class Main {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbbaccc";

//        String s1 = "";
//        String s2 = "";
//        String s3 = "";

//        String s1 = "a";
//        String s2 = "b";
//        String s3 = "a";

//        String s1 = "a";
//        String s2 = "";
//        String s3 = "a";

//        String s1 = "";
//        String s2 = "abc";
//        String s3 = "ab";

        Solution solution = new Solution();
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}