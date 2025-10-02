package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{3,4},{2,3},{1,2}};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRightInterval(intervals)));
    }
}