package org.akhil;

public class Main {
    public static void main(String[] args) {
        char[][] grid = {{'X','Y','.'},{'Y','.','.'}};

        Solution solution = new Solution();
        System.out.println(solution.numberOfSubmatrices(grid));
    }
}