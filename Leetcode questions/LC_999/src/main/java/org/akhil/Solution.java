package org.akhil;

public class Solution {
    // O(M*N)/O(1)
    public int numRookCaptures(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int rRow = 0;
        int rCol = 0;
        boolean found = false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'R'){
                    rRow = i;
                    rCol = j;
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }

        int result = 0;
        // check down
        for(int i=rRow-1; i>=0; i--){
            if(board[i][rCol] == '.'){
                continue;
            }
            if(board[i][rCol] == 'B'){
                break;
            }
            if(board[i][rCol] == 'p'){
                result++;
                break;
            }
        }

        // check up
        for(int i=rRow+1; i<m; i++){
            if(board[i][rCol] == '.'){
                continue;
            }
            if(board[i][rCol] == 'B'){
                break;
            }
            if(board[i][rCol] == 'p'){
                result++;
                break;
            }
        }

        // check left
        for(int i=rCol-1; i>=0; i--){
            if(board[rRow][i] == '.'){
                continue;
            }
            if(board[rRow][i] == 'B'){
                break;
            }
            if(board[rRow][i] == 'p'){
                result++;
                break;
            }
        }

        // check right
        for(int i=rCol+1; i<n; i++){
            if(board[rRow][i] == '.'){
                continue;
            }
            if(board[rRow][i] == 'B'){
                break;
            }
            if(board[rRow][i] == 'p'){
                result++;
                break;
            }
        }

        return result;
    }
}
