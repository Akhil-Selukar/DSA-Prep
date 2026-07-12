package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.arrayRankTransform(arr)));
    }
}