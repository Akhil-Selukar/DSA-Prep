package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{6,9}};
//        int[] newInterval = {2,5};

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.insert(intervals, newInterval)));
    }
}