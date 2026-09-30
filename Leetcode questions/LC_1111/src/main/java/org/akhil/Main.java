package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String seq = "()(())()";

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxDepthAfterSplit(seq)));
    }
}