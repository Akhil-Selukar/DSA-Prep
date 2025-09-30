package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{1,2,4},{3,3,1}};

        Solution solution = new Solution();
        System.out.println(solution.deleteGreatestValue(grid));
    }
}