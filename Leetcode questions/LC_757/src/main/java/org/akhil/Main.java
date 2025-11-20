package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{3,7},{8,9}};

        Solution solution = new Solution();
        System.out.println(solution.intersectionSizeTwo(intervals));
    }
}