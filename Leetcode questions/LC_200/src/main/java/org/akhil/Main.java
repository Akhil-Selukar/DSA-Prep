package org.akhil;

public class Main {
    public static void main(String[] args) {
        char[][] matrix = new char[4][5];

        matrix[0][0] = '1';
        matrix[0][1] = '1';
        matrix[1][0] = '1';
        matrix[1][1] = '1';
        matrix[2][2] = '1';
        matrix[3][3] = '1';
        matrix[3][4] = '1';

        Solution solution = new Solution();

        // This solution can be improved drastically by using recursion (check submitted code on Leetcode)
        System.out.println(solution.numIslands(matrix));
    }
}
