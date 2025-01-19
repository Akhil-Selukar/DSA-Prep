package org.akhil;

import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] != '.'){
                    if(!isSafe(board, i, j, board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char num) {
        // row safe
        for(int i=0; i<board.length; i++){
            if(i != col && board[row][i] == num){
                return false;
            }
        }

        // column safe
        for(int i=0; i<board.length; i++){
            if(i!=row && board[i][col] == num){
                return false;
            }
        }

        // 3X3 board safe
        int sqrt = (int)Math.sqrt(board.length);
        int rowStartIndex = row - row%sqrt;
        int colStartIndex = col - col%sqrt;

        int rowEndIndex = rowStartIndex + sqrt;
        int colEndIndex = colStartIndex + sqrt;

        for(int i=rowStartIndex; i<rowEndIndex; i++){
            for(int j=colStartIndex; j<colEndIndex; j++){
                if(i != row && j != col && board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
