package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(M*N)/O(M*N)
    public char[][] rotateTheBox(char[][] boxGrid) {
        int rows = boxGrid.length;
        int cols = boxGrid[0].length;

        char[][] result = new char[cols][rows];

        // initially all cells are considered as empty in result
        for(char[] row:result){
            Arrays.fill(row, '.');
        }

        // check boxGrid row-wise and add it in result column wise
        for(int i=0; i<rows; i++){
            int last=cols-1;

            for(int j=cols-1; j>=0; j--){
                if(boxGrid[i][j] == '*') {  // if its an stationary obstacle then last index will be updated
                    result[j][rows-i-1] = '*';
                    last = j-1;
                } else if(boxGrid[i][j] == '#') {   // it it is a stone then slide it to last index
                    result[last][rows-i-1] = '#';
                    last--;
                }
            }
        }

        return result;
    }
}
