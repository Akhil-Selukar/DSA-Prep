package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] edges ={{1,2},{2,3},{3,4},{1,4},{1,5}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRedundantConnection(edges)));
    }
}