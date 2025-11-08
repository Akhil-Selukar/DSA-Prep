package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int c = 5;
        int[][] connections = {{1,2},{2,3},{3,4},{4,5}};
        int[][] queries = {{1,3},{2,1},{1,1},{2,2},{1,2}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.processQueries(c, connections, queries)));
    }
}