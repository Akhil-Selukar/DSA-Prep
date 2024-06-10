package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SingleDimensionalArray sda = new SingleDimensionalArray(5);

        sda.insertElementAtIndex(0, 10);
        sda.insertElementAtIndex(1, 20);
        sda.insertElementAtIndex(3, 30);
        sda.insertElementAtIndex(1, 40);
        sda.insertElementAtIndex(7, 70);

        System.out.println(Arrays.toString(sda.arr));
    }
}