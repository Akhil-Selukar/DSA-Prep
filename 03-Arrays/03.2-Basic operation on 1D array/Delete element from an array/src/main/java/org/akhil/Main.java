package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SingleDimensionalArray sda = new SingleDimensionalArray(5);

        System.out.println("Array before deleting any element "+Arrays.toString(sda.arr));

        sda.deleteElementOfAnArray(3);

        System.out.println("Array after deleting 3rd element "+Arrays.toString(sda.arr));
    }
}