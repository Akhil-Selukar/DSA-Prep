package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{7,2,9},{1,5,0},{2,6,6}};
        int k = 20;

        Solution solution = new Solution();
        System.out.println(solution.countSubmatrices(grid, k));
    }
}