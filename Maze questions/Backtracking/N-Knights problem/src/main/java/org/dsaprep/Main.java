package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int n = 3;

        nKnight(n);
    }

    private static void nKnight(int n) {
        boolean[][] board = new boolean[n][n];
        nKnightSolver(board, 0, 0, n);
    }

    private static void nKnightSolver(boolean[][] board, int rowIndex, int columnIndex, int knights) {
        if(knights == 0){
            displayBoard(board);
            return;
        }

        if(rowIndex == board.length-1 && columnIndex == board.length){
            return;
        }

        if(columnIndex == board.length){
            nKnightSolver(board, rowIndex+1, 0, knights);
            return;
        }

        if(isSafe(board, rowIndex, columnIndex)){
            board[rowIndex][columnIndex] = true;
            nKnightSolver(board, rowIndex, columnIndex+1, knights-1);
            board[rowIndex][columnIndex] = false;
        }

        nKnightSolver(board, rowIndex, columnIndex+1, knights);
    }

    private static boolean isSafe(boolean[][] board, int rowIndex, int columnIndex) {
        if(isValidSpot(board, rowIndex-2, columnIndex-1)){
            if(board[rowIndex-2][columnIndex-1]){
                return false;
            }
        }

        if(isValidSpot(board, rowIndex-2, columnIndex+1)){
            if(board[rowIndex-2][columnIndex+1]){
                return false;
            }
        }

        if(isValidSpot(board, rowIndex-1, columnIndex-2)){
            if(board[rowIndex-1][columnIndex-2]){
                return false;
            }
        }

        if(isValidSpot(board, rowIndex+1, columnIndex-2)){
            if(board[rowIndex+1][columnIndex-2]){
                return false;
            }
        }

        if(isValidSpot(board, rowIndex+2, columnIndex-1)){
            if(board[rowIndex+2][columnIndex-1]){
                return false;
            }
        }

        if(isValidSpot(board, rowIndex+2, columnIndex+1)){
            if(board[rowIndex+2][columnIndex+1]){
                return false;
            }
        }

        if(isValidSpot(board, rowIndex+1, columnIndex+2)){
            if(board[rowIndex+1][columnIndex+2]){
                return false;
            }
        }

        if(isValidSpot(board, rowIndex-1, columnIndex+2)){
            if(board[rowIndex-1][columnIndex+2]){
                return false;
            }
        }

        return true;
    }

    private static boolean isValidSpot(boolean[][] board, int rowIndex, int columnIndex){
        if(rowIndex >= 0 && rowIndex < board.length && columnIndex >= 0 && columnIndex < board.length){
            return true;
        }
        return false;
    }

    private static void displayBoard(boolean[][] board) {
        for(boolean[] row:board){
            for(boolean spot:row){
                if(spot){
                    System.out.print("K ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
        System.out.println("==========\n");
    }

}