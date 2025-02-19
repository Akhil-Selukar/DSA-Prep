package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        char[] chars = {'a','a','b','b','c','c','c'};
//        char[] chars = {'a'};
//        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','c','c'};
        char[] chars = {'a','a','b','b','c','a','a'};

        Solution solution = new Solution();
        System.out.println(solution.compress(chars));
        System.out.println(Arrays.toString(chars));
    }
}