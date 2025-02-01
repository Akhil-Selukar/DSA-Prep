package org.example;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int target = 5;
//        int target = 20;
//        int target = -20;
        int target = 200;

        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, target));
    }
}