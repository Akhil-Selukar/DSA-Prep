package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String s = "paper";
//        String t = "title";

        String s = "foo";
        String t = "bar";

//        String s = "add";
//        String t = "egg";

//        String s = "badc";
//        String t = "baba";

        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic(s, t));
    }
}