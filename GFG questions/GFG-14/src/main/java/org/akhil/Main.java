package org.akhil;

public class Main {
    public static void main(String[] args) {
        int noOfRows = 4;
        int noOfColumns = 5;
//        int[][] A = {{0,0},{1,1},{2,2},{3,3}};
        int[][] A = {{1,1},{0,1},{3,3},{3,4}};
        Solution solution = new Solution();

        System.out.println(solution.numOfIslands(noOfRows, noOfColumns, A));
    }
}