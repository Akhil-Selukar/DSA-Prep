package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1,0,0));
        grid.add(Arrays.asList(0,0,0));
        grid.add(Arrays.asList(0,0,0));

        Solution solution = new Solution();
        System.out.println(solution.maximumSafenessFactor(grid));
    }
}