package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(List.of(5,8,1));
        intervals.add(List.of(6,7,7));
        intervals.add(List.of(4,7,3));
        intervals.add(List.of(9,10,6));
        intervals.add(List.of(7,8,2));
        intervals.add(List.of(11,14,3));
        intervals.add(List.of(3,5,5));

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maximumWeight(intervals)));
    }
}