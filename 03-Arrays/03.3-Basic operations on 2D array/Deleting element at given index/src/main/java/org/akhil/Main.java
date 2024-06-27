package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TwoDimensionArray twoDimensionArray = new TwoDimensionArray(3,3);

        System.out.println("Array before deletion :");
        System.out.println(Arrays.deepToString(twoDimensionArray.arr));

        twoDimensionArray.deleteValueAtGivenIndex(1,1);

        System.out.println("Array after deletion :");
        System.out.println(Arrays.deepToString(twoDimensionArray.arr));
    }
}