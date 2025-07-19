package org.akhil;

public class Main {
    public static void main(String[] args) {
        String[] folder = {"/a","/a/b","/c/f","/c/d","/c/d/e"};
//        String[] folder = {"/a/b/c","/a/b/ca","/a/b/d"};

        Solution solution = new Solution();
        System.out.println(solution.removeSubfolders(folder));
    }
}