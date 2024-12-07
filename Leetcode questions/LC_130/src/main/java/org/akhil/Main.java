package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},
                          {'X','O','O','X'},
                          {'X','X','O','X'},
                          {'X','O','X','X'}};

        Solution solution = new Solution();

        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}