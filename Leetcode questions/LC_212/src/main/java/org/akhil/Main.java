package org.akhil;

public class Main {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        Solution solution = new Solution();
        System.out.println(solution.findWords(board, words));
    }
}