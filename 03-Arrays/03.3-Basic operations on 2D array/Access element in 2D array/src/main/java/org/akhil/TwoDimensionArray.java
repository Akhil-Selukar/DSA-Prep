package org.akhil;

public class TwoDimensionArray {
    int[][] arr;
    public TwoDimensionArray(int numberOfRows, int numberOfColumns) {
        arr = new int[numberOfRows][numberOfColumns];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    // Insert value at given index.
    public void insertValueAtGivenIndex(int row, int col, int value){
        try{
            if(arr[row][col] == Integer.MIN_VALUE){
                arr[row][col] = value;
                System.out.println("Value inserted successfully..!!");
            } else {
                System.out.println("The cell at given index is already occupied.");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Given array indices are invalid");
        }
    }

    // Access element at given row and column
    public void accessElementAtGivenIndex(int row, int col){
        System.out.println("Accessing element at "+row+"th row and "+col+"th column");
        try{
            System.out.println("Element at "+row+"th row and "+col+"th column is "+arr[row][col]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Given array indices are invalid");
        }
    }
}
