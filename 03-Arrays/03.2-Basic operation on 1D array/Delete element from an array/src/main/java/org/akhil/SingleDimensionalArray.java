package org.akhil;

public class SingleDimensionalArray {
    int[] arr = null;

    public SingleDimensionalArray(int sizeOfArray) {
        this.arr = new int[sizeOfArray];

        for(int i=0;i<arr.length; i++){
            this.arr[i] = (i+1)*10;
        }
    }

    // Delete element at specific index.
    public void deleteElementOfAnArray(int index){
        try{
            this.arr[index] = Integer.MIN_VALUE;
            System.out.println("Element deleted successfully!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array index is not present.!!");
        }
    }
}
