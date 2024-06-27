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

    // Search value in 2D array
    public void searchValueIn2DArray(int value){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr.length; col++){
                if(arr[row][col] == value){
                    System.out.println(value + " is present at row number "+row+" and column number "+col);
                    return;
                }
            }
        }
        System.out.println("Given value is not present in the array..!!");
    }
}
