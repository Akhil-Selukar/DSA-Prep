package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];

        int noOfSolutions = nQueensSolution(board, 0);  // Here 0 is the starting row i.e. we are starting to place queens from row index 0.
        System.out.println(noOfSolutions);
    }

    protected static int nQueensSolution(boolean[][] board, int rowIndex) {
        // If all queens are placed successfully (i.e. base condition)
        if(rowIndex == board.length){
            displayBoard(board);
            return 1;
        }

        // Place queens
        int solutionCount = 0;
        for(int column=0; column<board.length; column++){
            if(isQueenSafe(board, rowIndex, column)){
                board[rowIndex][column] = true;
                solutionCount = solutionCount + nQueensSolution(board, rowIndex+1);
                board[rowIndex][column] = false;
            }
        }
        return solutionCount;
    }

    private static boolean isQueenSafe(boolean[][] board, int rowIndex, int column) {
        // Check vertical threat
        for(int i=0; i<rowIndex; i++){
            if(board[i][column]){
                return false;
            }
        }

        // Check right diagonal threat
        int maxRightThreats = Math.min(rowIndex, board.length-column-1);
        for(int i=1; i<=maxRightThreats; i++){
            if(board[rowIndex-i][column+i]){
                return false;
            }
        }

        // Check left diagonal threat
        int maxLeftThreats = Math.min(rowIndex, column);
        for(int i=1; i<=maxLeftThreats; i++){
            if(board[rowIndex-i][column-i]){
                return false;
            }
        }

        // If no threat in all three direction then queen is safe.
        return true;
    }

    private static void displayBoard(boolean[][] board) {
        for(boolean[] row: board){
            for(boolean place:row){
                if(place){
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println("=====================");
    }
}