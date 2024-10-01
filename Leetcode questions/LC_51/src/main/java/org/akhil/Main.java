package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];

        return nQueenSolver(board, 0);
    }

    private static List<List<String>> nQueenSolver(boolean[][] board, int rowIndex) {
        List<List<String>> ans = new ArrayList<>();
        if(rowIndex == board.length){
            List<String> boardStatus = displayBoard(board);
            ans.add(boardStatus);
            return ans;
        }

        for(int columnIndex = 0; columnIndex<board.length; columnIndex++){
            if(isSafe(board, rowIndex, columnIndex)){
                board[rowIndex][columnIndex] = true;
                ans.addAll(nQueenSolver(board, rowIndex+1));
                board[rowIndex][columnIndex] = false;
            }
        }
        return ans;
    }

    private static boolean isSafe(boolean[][] board, int rowIndex, int columnIndex) {

        // Check upward threats
        for(int i=0; i<rowIndex; i++){
            if(board[i][columnIndex]){
                return false;
            }
        }

        // Check right threats
        int rightMax = Math.min(rowIndex, board.length-1-columnIndex);
        for(int i=1; i<=rightMax; i++){
            if(board[rowIndex-i][columnIndex+i]){
                return false;
            }
        }

        // Check left threats
        int leftMax = Math.min(rowIndex, columnIndex);
        for(int i=1; i<=leftMax; i++){
            if(board[rowIndex-i][columnIndex-i]){
                return false;
            }
        }
        return true;
    }

    private static List<String> displayBoard(boolean[][] board) {
        List<String> currentBoard = new ArrayList<>();
        for(boolean[] row:board){
            StringBuilder sb = new StringBuilder();
            for(boolean spot:row){
                if(spot){
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            currentBoard.add(sb.toString());
        }
        return currentBoard;
    }
}