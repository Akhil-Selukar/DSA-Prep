package org.akhil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> edges = List.of(List.of(0,1),List.of(0,2),List.of(2,5),List.of(3,4),List.of(4,2));

        Solution solution = new Solution();
        System.out.println(solution.findSmallestSetOfVertices(n, edges));
    }
}