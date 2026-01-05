package org.akhil;

public class Main {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};

        Solution solution = new Solution();
        System.out.println(solution.maxMatrixSum(matrix));
    }
}