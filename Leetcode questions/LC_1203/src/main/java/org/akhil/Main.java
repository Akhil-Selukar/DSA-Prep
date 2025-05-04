package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 8;      // number of elements.
        int m = 2;      // number of groups.
        int[] group = {-1,-1,1,0,0,1,0,-1};
//        beforeItems = [[],[6],[5],[6],[3,6],[],[],[]];
        List<List<Integer>> beforeItems = Arrays.asList(List.of(), List.of(6), List.of(5), List.of(6), Arrays.asList(3,6),
                List.of(), List.of(), List.of());

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortItems(n, m, group, beforeItems)));
    }
}