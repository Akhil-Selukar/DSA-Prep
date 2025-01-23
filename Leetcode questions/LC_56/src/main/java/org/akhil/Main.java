package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{15,18},{8,10},{2,6}};
//        int[][] intervals = {{1,3},{2,6},{4,10},{9,18}};
//        int[][] intervals = {{1,3},{4,6},{8,10},{15,18}};
//        int[][] intervals = {{1, 3}, {3, 6}, {6, 10}, {15, 18}};
//        int[][] intervals = {{1,3}};
//        int[][] intervals = {};
//        int[][] intervals = {{1,3},{0,2}};
//        int[][] intervals = {{1,3},{0,5}};
//        int[][] intervals = {{1,4},{0,0}};
        int[][] intervals = {{1,4},{-3,5}};


        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }
}