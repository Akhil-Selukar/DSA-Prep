package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};

        Solution solution = new Solution();
        System.out.println(solution.calculateMinimumHP(dungeon));
    }
}