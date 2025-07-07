package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3,4));
        triangle.add(List.of(6,5,7));
        triangle.add(List.of(4,1,8,3));
//        triangle.add(List.of(-10));

        Solution solution = new Solution();
        System.out.println(solution.minimumTotal(triangle));
//        System.out.println(solution.minimumTotal1(triangle));
    }
}