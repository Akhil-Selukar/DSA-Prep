package org.akhil;

public class SingleDimensionalArray {
    
    public void searchElementInArray(int elementToSearch, int[] arr){
        for(int i=0; i< arr.length; i++){
            if(arr[i] == elementToSearch){
                System.out.println("Element found at index "+i);
                return;
            }
        }
        System.out.println("Element not found in given array");
    }
}
