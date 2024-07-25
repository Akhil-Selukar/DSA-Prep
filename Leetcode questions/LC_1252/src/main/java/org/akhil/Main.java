package org.akhil;

public class Main {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] indices = {{0,1},{1,1}};

        System.out.println(oddCells(m,n,indices));
    }

    public static int oddCells(int m, int n, int[][] indices) {
        int count = 0;
        int[][] matrix = new int[m][n];

        for(int i=0; i<indices.length; i++){
            int row = indices[i][0];
            int col = indices[i][1];
            for(int j=0; j<n; j++){
                matrix[row][j] +=1;
            }
            for(int j=0; j<m; j++){
                matrix[j][col] +=1;
            }
        }

        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(matrix[row][col]%2 == 1)
                    count++;
            }
        }
        return count;
    }
}