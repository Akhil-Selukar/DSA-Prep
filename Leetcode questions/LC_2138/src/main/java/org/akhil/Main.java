package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.divideString(s, k, fill)));
    }
}