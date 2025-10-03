package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] aliceSizes = {1,2,5};
        int[] bobSize = {2,4};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.fairCandySwap(aliceSizes, bobSize)));
    }
}