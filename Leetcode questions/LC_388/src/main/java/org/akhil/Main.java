package org.akhil;

public class Main {
    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        Solution solution = new Solution();
        System.out.println(solution.lengthLongestPath(input));
    }
}