package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] edgeList = {{0,1,10},{1,2,5},{2,3,9},{3,4,13}};
        int[][] queries = {{0,4,14},{1,4,13}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.distanceLimitedPathsExist(n, edgeList, queries)));
    }
}