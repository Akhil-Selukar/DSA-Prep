package org.akhil;

public class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            // left boundary
            if(board[i][0] == 'O' && !visited[i][0]){
                dfs(board, visited, i, 0);
            }

            // right boundary
            if(board[i][board[0].length-1] == 'O' && !visited[i][board[0].length-1]){
                dfs(board, visited, i, board[0].length-1);
            }
        }

        for(int j=0; j<board[0].length; j++){
            // upper boundary
            if(board[0][j] == 'O' && !visited[0][j]){
                dfs(board, visited, 0, j);
            }

            // lower boundary
            if(board[board.length-1][j] == 'O' && !visited[board.length-1][j]){
                dfs(board, visited, board.length-1, j);
            }
        }

        // replace remaining O's
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j){
        visited[i][j] = true;

        for(int[] direction:directions){
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if(newI >=0 && newJ >=0 && newI < board.length && newJ < board[0].length && !visited[newI][newJ] && board[newI][newJ] == 'O'){
                dfs(board, visited, newI, newJ);
            }
        }
    }
}
