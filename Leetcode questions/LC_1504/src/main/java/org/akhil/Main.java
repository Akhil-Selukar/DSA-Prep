package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] mat = {{1,0,1},{1,1,0},{1,1,0}};

        Solution solution = new Solution();
        System.out.println(solution.numSubmat(mat));
    }
}