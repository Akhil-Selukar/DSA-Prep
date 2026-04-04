package org.akhil;

public class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1){
            return encodedText;
        }

        int totalChars = encodedText.length();
        int cols = totalChars/rows;

        // construct grid
        char[][] grid = new char[rows][cols];
        int index = 0;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                grid[r][c] = encodedText.charAt(index++);
            }
        }

        // create string
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<cols; i++){
            int row=0;
            int col=i;
            while(row < rows && col < cols){
                sb.append(grid[row][col]);
                row++;
                col++;
            }
        }

        return sb.toString().stripTrailing();
    }
}
