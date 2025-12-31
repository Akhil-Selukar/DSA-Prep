package org.akhil;

public class Main {
    public static void main(String[] args) {
        int row = 2;
        int col = 2;
        int[][] cells = {{1,1},{2,1},{1,2},{2,2}};

        Solution solution = new Solution();
        System.out.println(solution.latestDayToCross(row, col, cells));
    }
}