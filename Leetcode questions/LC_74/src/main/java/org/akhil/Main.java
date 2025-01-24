package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int target = 3;
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int target = 13;
//        int[][] matrix = {{1,3,5,7}};
//        int target = 1;
//        int[][] matrix = {{1,3,5,7}};
//        int target = 2;
        int[][] matrix = {{2,1,1,2}};
        int target = 2;

        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, target));
    }
}