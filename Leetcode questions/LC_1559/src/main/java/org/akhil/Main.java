package org.akhil;

public class Main {
    public static void main(String[] args) {
        char[][] grid = {{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}};

        Solution solution = new Solution();
        System.out.println(solution.containsCycle(grid));
    }
}