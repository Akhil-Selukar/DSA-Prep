package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0}, {0,1,0}, {1,1,1}};

        Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.updateMatrix(mat)));
    }
}