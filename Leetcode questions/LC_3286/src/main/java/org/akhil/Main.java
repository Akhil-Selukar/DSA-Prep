package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();

//        grid.add(Arrays.asList(0,1,0,0,0));
//        grid.add(Arrays.asList(0,1,0,1,0));
//        grid.add(Arrays.asList(0,0,0,1,0));
//        int health = 1;

        grid.add(Arrays.asList(0,1,1,0,0,0));
        grid.add(Arrays.asList(1,0,1,0,0,0));
        grid.add(Arrays.asList(0,1,1,1,0,1));
        grid.add(Arrays.asList(0,0,1,0,1,0));
        int health = 3;

        Solution solution = new Solution();
        System.out.println(solution.findSafeWalk(grid, health));
    }
}