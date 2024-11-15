package org.akhil;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        // initialize the board with empty values
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], ' ');
        }
        Scanner sc = new Scanner(System.in);
        char player = 'X';
        boolean gameOver = false;
        int moves = 0;

        displayBoard(board);
        while (!gameOver) {
            System.out.println("Player " + player + "'s turn");
//            displayBoard(board);
            System.out.print("Enter row and column number : ");
            int row = sc.nextInt();
            int column = sc.nextInt();

            if (board[row][column] == ' ') {
                moves++;
                board[row][column] = player;
                displayBoard(board);
                boolean win = checkWin(board, player);
                if(win || (moves == 9)){
                    if(win){
                        System.out.println("Player "+player+" won the game..!!");
                    } else {
                        System.out.println("This game is a draw..!!");
                    }
                    gameOver = true;
                }

                player = player == 'X'? 'O': 'X';
            } else {
                displayBoard(board);
                System.out.println("Invalid selection..!!");
            }
            System.out.println("======================================");
        }
    }

    private static boolean checkWin(char[][] board, char player) {
        // check vertical win
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // check horizontal win
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // check diagonal win
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        // No win
        return false;
    }

    private static void displayBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
        }
    }
}