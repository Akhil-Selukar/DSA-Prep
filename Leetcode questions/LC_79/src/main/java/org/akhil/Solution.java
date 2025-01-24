package org.akhil;

public class Solution {
    public boolean exist(char[][] board, String word) {
       boolean[][] visited = new boolean[board.length][board[0].length];

       for(int i=0; i<board.length; i++){
           for(int j=0; j<board[0].length; j++){
                if(helper(board, visited, word, i, j, 0)){
                    return true;
                }
           }
       }
       return false;
    }

    private boolean helper(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if(word.length() == index){
            return true;
        }

        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        boolean response = helper(board, visited, word, i, j+1, index+1)
                || helper(board, visited, word, i+1, j, index+1)
                || helper(board, visited, word, i, j-1, index+1)
                || helper(board, visited, word, i-1, j, index+1);
        visited[i][j] = false;

        return response;
    }
}
