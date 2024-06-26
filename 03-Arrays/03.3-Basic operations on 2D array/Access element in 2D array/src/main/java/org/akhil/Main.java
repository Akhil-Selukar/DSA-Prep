package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TwoDimensionArray twoDimensionArray = new TwoDimensionArray(3,3);

        twoDimensionArray.insertValueAtGivenIndex(0,0,1);
        twoDimensionArray.insertValueAtGivenIndex(0,1,2);
        twoDimensionArray.insertValueAtGivenIndex(1,1,5);

        System.out.println(Arrays.deepToString(twoDimensionArray.arr));

        twoDimensionArray.accessElementAtGivenIndex(1,1);
    }
}