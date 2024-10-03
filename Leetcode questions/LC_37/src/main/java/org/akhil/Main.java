package org.akhil;

public class Main {
    public static void main(String[] args) {
        char[][] board = {
                {'3', '0', '6', '5', '0', '8', '4', '0', '0'},
                {'5', '2', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '8', '7', '0', '0', '0', '0', '3', '1'},
                {'0', '0', '3', '0', '1', '0', '0', '8', '0'},
                {'9', '0', '0', '8', '6', '3', '0', '0', '5'},
                {'0', '5', '0', '0', '9', '0', '6', '0', '0'},
                {'1', '3', '0', '0', '0', '0', '2', '5', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '7', '4'},
                {'0', '0', '5', '2', '0', '6', '3', '0', '0'}};

        solveSudoku(board);
        displayBoard(board);
    }

    private static void displayBoard(char[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private static boolean solveSudokuHelper(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean isEmpty = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '0'){
                    isEmpty = true;
                    row = i;
                    col = j;
                }
            }
            if(isEmpty){
                break;
            }
        }

        if(!isEmpty){  // base condition
            return true; // sudoku is solved
        }

        for(char i='1'; i<=57; i++){
            if(isSafe(board, row, col, i)){
                board[row][col] = i;
                if(solveSudokuHelper(board)){
                    return true;
                }else{
                    board[row][col] = '0';
                }
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, int num) {
        // check in row
        for(int i=0; i<board.length; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        // check in col
        for(int i=0; i<board.length; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        // check in sub-square
        int sqRoot = (int)Math.sqrt(board.length);
        int rowIndex = row - row%sqRoot;
        int colIndex = col - col%sqRoot;
        for(int i=rowIndex; i<rowIndex+sqRoot; i++){
            for(int j=colIndex; j<colIndex+sqRoot; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        // else it is safe
        return true;
    }
}