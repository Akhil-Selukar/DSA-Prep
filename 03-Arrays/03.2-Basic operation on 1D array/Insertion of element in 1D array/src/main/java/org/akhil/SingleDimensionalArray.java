package org.akhil;

public class SingleDimensionalArray {
    int[] arr = null;

    public SingleDimensionalArray(int size) {
        arr = new int[size];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insertElementAtIndex(int index, int value){
        try{
            if(arr[index] == Integer.MIN_VALUE){
                arr[index] = value;
                System.out.println("Value inserted successfully.");
            }else{
                System.out.println("Array index was already occupied.");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Given array index is incorrect.");
        }
    }
}




