package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

        Solution solution = new Solution();
        solution.gameOfLife(board);

        System.out.println(Arrays.deepToString(board));
    }
}