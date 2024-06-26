package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TwoDimensionArray twoDimensionalArray = new TwoDimensionArray(3, 3);

        twoDimensionalArray.insertValueAtGivenIndex(0,0,15);

        System.out.println(Arrays.deepToString(twoDimensionalArray.arr));
    }
}