package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        int success = 7;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.successfulPairs(spells, potions, success)));
    }
}