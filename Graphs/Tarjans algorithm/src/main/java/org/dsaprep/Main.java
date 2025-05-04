package org.dsaprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 4;
//        int[][] connections = {{0,1},{1,2},{2,0},{1,3}};        // here tihs represent edges and not adjacency list.
        List<List<Integer>> connections = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,2),
                Arrays.asList(2,0),
                Arrays.asList(1,3));

        Solution solution = new Solution();

        System.out.println(solution.criticalConnections(n, connections));
    }
}