package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};

//        int n = 6;
//        int[][] rectangles = {{0,0,3,2},{3,0,6,2},{0,2,2,5},{0,5,2,6},{2,2,4,6},{4,2,5,6},{5,2,6,6}};

        Solution solution = new Solution();
        System.out.println(solution.checkValidCuts(n, rectangles));
    }
}