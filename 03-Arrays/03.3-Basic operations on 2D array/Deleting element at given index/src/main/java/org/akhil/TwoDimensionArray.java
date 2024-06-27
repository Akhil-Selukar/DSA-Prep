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

    // Delete value at given index
    public void deleteValueAtGivenIndex(int rowIndex, int columnIndex){
        try{
            arr[rowIndex][columnIndex] = Integer.MIN_VALUE;
            System.out.println("Value at row "+rowIndex+" and column "+columnIndex+" is deleted successfully..!!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Given array index are invalid..!!");
        }
    }
}
