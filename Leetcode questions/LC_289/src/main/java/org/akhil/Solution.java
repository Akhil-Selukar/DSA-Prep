package org.akhil;

public class Solution {

    // Solution 1 - O(N^2)/O(N)

//    int[][] directions = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {0, 1}, {1, 1}, {1, 0}, {-1, 1}};
//
//    public void gameOfLife(int[][] board) {
//        int[][] next = new int[board.length][board[0].length];
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                int liveNeighbours = findLiveNeighbours(board, i, j);
//
//                if (board[i][j] == 1) {
//                    if (liveNeighbours < 2) {
//                        next[i][j] = 0;
//                    }
//                    if (liveNeighbours == 2 || liveNeighbours == 3) {
//                        next[i][j] = 1;
//                    }
//                    if (liveNeighbours > 3) {
//                        next[i][j] = 0;
//                    }
//                } else {
//                    if (liveNeighbours == 3) {
//                        next[i][j] = 1;
//                    }
//                }
//            }
//        }
//
//        for(int i=0; i<board.length; i++){
//            for(int j=0; j<board[0].length; j++){
//                board[i][j] = next[i][j];
//            }
//        }
//    }
//
//    private int findLiveNeighbours(int[][] board, int i, int j) {
//        int liveCells = 0;
//        for (int[] direction : directions) {
//            int x = i + direction[0];
//            int y = j + direction[1];
//
//            if (x >= 0 && y >=0 && x < board.length && y < board[0].length && board[x][y] == 1) {
//                liveCells++;
//            }
//        }
//        return liveCells;
//    }


    // Solution 2 - In place solution
    int[][] directions = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {0, 1}, {1, 1}, {1, 0}, {-1, 1}};
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeighbours = findLiveNeighbours(board, i, j);

                if (board[i][j] == 1) {
                    if (liveNeighbours < 2) {
                        board[i][j] = 1;
                    }
                    if (liveNeighbours == 2 || liveNeighbours == 3) {
                        board[i][j] = 3;
                    }
                    if (liveNeighbours > 3) {
                        board[i][j] = 1;
                    }
                } else {
                    if (liveNeighbours == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int findLiveNeighbours(int[][] board, int i, int j) {
        int liveCells = 0;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];

            if (x >= 0 && y >=0 && x < board.length && y < board[0].length && (board[x][y] & 1) == 1) {
                liveCells++;
            }
        }
        return liveCells;
    }

}

