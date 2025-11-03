package org.akhil;

public class Main {
    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int[][] guards = {{0,0},{1,1},{2,3}};
        int[][] walls = {{0,1},{2,2},{1,4}};

        Solution solution = new Solution();
        System.out.println(solution.countUnguarded(m, n, guards, walls));
    }
}