package org.akhil;

public class Main {
    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};

        Solution solution = new Solution();
        System.out.println(solution.countBattleships(board));
    }
}