package org.akhil;

public class Main {
    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";

//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "SEE";

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";

        Solution solution = new Solution();

        System.out.println(solution.exist(board, word));
    }
}