package org.akhil;

public class Main {
    public static void main(String[] args) {
        SingleDimensionalArray sda = new SingleDimensionalArray(5);

        sda.insertElementAtIndex(0, 10);
        sda.insertElementAtIndex(1, 20);
        sda.insertElementAtIndex(2, 30);
        sda.insertElementAtIndex(3, 40);
        sda.insertElementAtIndex(4, 50);

        // Accessing elements
        int firstElement = sda.arr[0];
        System.out.println("First element in the array is "+firstElement);
        int fourthElement = sda.arr[3];
        System.out.println("Fourth element in the array is "+fourthElement);

    }
}

