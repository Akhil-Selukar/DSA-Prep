package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};

        Solution solution = new Solution();
        System.out.println(solution.removeStones(stones));
    }
}