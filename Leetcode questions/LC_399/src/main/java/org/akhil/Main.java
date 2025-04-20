package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0,3.0};
        List<List<String>> queries = List.of(List.of("a","c"),List.of("b","a"),List.of("a","e"),List.of("a","a"),List.of("x","x"));

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));
    }
}