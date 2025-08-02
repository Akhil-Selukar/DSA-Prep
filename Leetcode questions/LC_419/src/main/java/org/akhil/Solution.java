package org.akhil;

public class Solution {
    // Solution 1 - Using visited array
    // O(M*N)/O(M*N)
//    private final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
//    public int countBattleships(char[][] board) {
//        int m = board.length;
//        int n = board[0].length;
//        int ships = 0;
//
//        boolean[][] visited = new boolean[m][n];
//
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(board[i][j] == 'X' && !visited[i][j]){
//                    markShip(board, visited, i, j);
//                    ships++;
//                }
//            }
//        }
//        return ships;
//    }
//
//    private void markShip(char[][] board, boolean[][] visited, int i, int j){
//        visited[i][j] = true;
//        for(int[] direction:directions){
//            int newI = i + direction[0];
//            int newJ = j + direction[1];
//
//            if(newI >=0 && newI < board.length && newJ >=0 && newJ < board[0].length && board[newI][newJ] == 'X' && !visited[newI][newJ]){
//                markShip(board, visited, newI, newJ);
//            }
//        }
//    }


    // Solution 2 - without using visited array
    // O(M*N)/O(1)
    private final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ships = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'X'){
                    markShip(board, i, j);
                    ships++;
                }
            }
        }
        return ships;
    }

    private void markShip(char[][] board, int i, int j){
        board[i][j] = '.';
        for(int[] direction:directions){
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if(newI >=0 && newI < board.length && newJ >=0 && newJ < board[0].length && board[newI][newJ] == 'X'){
                markShip(board, newI, newJ);
            }
        }
    }
}
