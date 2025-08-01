package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;

        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(matrix, k));
    }
}