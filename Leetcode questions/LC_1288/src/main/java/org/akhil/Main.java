package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{3,6},{2,8}};

        Solution solution = new Solution();
        System.out.println(solution.removeCoveredIntervals(intervals));
    }
}