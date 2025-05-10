package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int n = 4;
//        int[][] relations = {{2,1},{3,1},{1,4}};
//        int k = 2;

//        int n = 5;
//        int[][] relations = {{2,1},{3,1},{4,1},{1,5}};
//        int k = 2;

        int n = 13;
        int[][] relations = {{12,8},{2,4},{3,7},{6,8},{11,8},{9,4},{9,7},{12,4},{11,4},{6,4},{1,4},{10,7},{10,4},{1,7},{1,8},{2,7},{8,4},{10,8},{12,7},{5,4},{3,4},{11,7},{7,4},{13,4},{9,8},{13,8}};
        int k = 9;

        Solution solution = new Solution();

        System.out.println(solution.minNumberOfSemesters(n, relations, k));
    }
}