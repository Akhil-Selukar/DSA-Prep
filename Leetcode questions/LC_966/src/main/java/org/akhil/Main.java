package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.spellchecker(wordlist, queries)));
    }
}