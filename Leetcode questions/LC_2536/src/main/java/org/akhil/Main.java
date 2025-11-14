package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] queries = {{1,1,2,2},{0,0,1,1}};

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.rangeAddQueries(n, queries)));
    }
}