package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1}};

        Solution solution = new Solution();
        System.out.println(solution.countSquares(matrix));
    }
}