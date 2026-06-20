package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int n = 5;
//        int[][] restrictions = {{2,1},{4,1}};

//        int n = 6;
//        int[][] restrictions = {};

        int n = 10;
        int[][] restrictions = {{5,3},{2,5},{7,4},{10,3}};

        Solution solution = new Solution();
        System.out.println(solution.maxBuilding(n, restrictions));
    }
}