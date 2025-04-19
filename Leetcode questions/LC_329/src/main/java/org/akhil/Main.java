package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};

        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(matrix));
    }
}