package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String[] words = {"a","b","ba","bca","bda","bdca"};
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};

        Solution solution = new Solution();
        System.out.println(solution.longestStrChain(words));
    }
}