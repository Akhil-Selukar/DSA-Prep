package org.akhil;

public class TwoDimensionArray {
    int[][] arr;

    public TwoDimensionArray(int row, int col) {
        arr = new int[row][col];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = (i+1)*(j+1);
            }
        }
    }

    // Traversal of 2D array
    public void traverse2DArray(){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[0].length; col++){
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
    }
}


