package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);

        Solution solution = new Solution();
        System.out.println(solution.minTime(n, edges, hasApple));
    }
}