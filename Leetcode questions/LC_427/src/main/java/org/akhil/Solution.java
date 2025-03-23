package org.akhil;

public class Solution {

    public Node construct(int[][] grid) {
        int n = grid.length;

        return helper(grid, 0, 0, n);
    }

    private Node helper(int[][] grid, int row, int col, int len){
        boolean allSame = true;
        int initialVal = grid[row][col];

        outerLoop:
        for(int i=row; i<row+len; i++){
            for(int j=col; j<col+len; j++){
                if(initialVal != grid[i][j]){
                    allSame = false;
                    break outerLoop;
                }
            }
        }

        if(allSame){
            return new Node(initialVal==1, true);
        } else {
            int lengthOfQuad = len/2;

            Node topLeft = helper(grid, row, col, lengthOfQuad);
            Node topRight = helper(grid, row, col+lengthOfQuad, lengthOfQuad);
            Node bottomLeft = helper(grid, row+lengthOfQuad, col, lengthOfQuad);
            Node bottomRight = helper(grid, row+lengthOfQuad, col+lengthOfQuad, lengthOfQuad);

            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
