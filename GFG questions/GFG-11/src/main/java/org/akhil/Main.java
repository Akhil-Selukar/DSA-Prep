package org.akhil;

public class Main {
    public static void main(String[] args) {
        int k = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};

        Solution solution = new Solution();

        System.out.println(solution.findOrder(dict, k));
    }
}