package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] deck = {17,13,11,2,3,5,7};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.deckRevealedIncreasing(deck)));
    }
}