package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String path = "/home//user/Documents/../Pictures";
//        String path = "///////";
//        String path = "/home/user/Documents//Pictures/./New";
//        String path = "/home//user/Documents/.../Pictures";
//        String path = "/home//user/Documents/../Pictures///";
//        String path = "/home//user/Documents/../../Pictures";
//        String path = "/../";
        String path = "/./home";

        Solution solution = new Solution();
        System.out.println(solution.simplifyPath(path));
    }
}