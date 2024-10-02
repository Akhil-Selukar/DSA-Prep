package org.dsaprep;

public class Main {
    public static void main(String[] args) {
        int[][] sudoku = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        boolean isSolved = solveSudoku(sudoku);
        if(isSolved){
//            System.out.println(Arrays.deepToString(sudoku));
            displayBoard(sudoku);
        } else {
            System.out.println("Given sudoku can not be solved..!!");
        }
    }

    protected static boolean solveSudoku(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = false; // To check is there are any empty cell left in the sudoku or not

        for(int rowIndex=0; rowIndex<board.length; rowIndex++){
            for(int columnIndex=0; columnIndex<board.length; columnIndex++){
                if(board[rowIndex][columnIndex] == 0){
                    emptyLeft = true;
                    row = rowIndex;
                    col = columnIndex;
                }
            }

            if(emptyLeft){
                break;
            }
        }

        if(!emptyLeft){         // base condition
            return true;
        }

        for(int num = 1; num<=board.length; num++){
            if(isSafe(board, row, col, num)){
                board[row][col] = num;
                if(solveSudoku(board)){
                    return true;        // no empty cell is left so sudoku is solved.
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // check for row
        for(int i=0; i<board.length; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        // check for column
        for(int i=0; i<board.length; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        // check in sub-square
        int n = (int) Math.sqrt(board.length);  // we can take this as 3 because generally sudoku's are 9X9 and hence sub-square will be of 3.
        int rowStart = row - row%n;
        int colStart = col - col%n;

        for(int i=rowStart; i<rowStart+n; i++){
            for(int j=colStart; j<colStart+n; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayBoard(int[][] sudoku) {
        for(int[] row:sudoku){
            for(int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}