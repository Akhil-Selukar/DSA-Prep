package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{4,2}};

        Solution solution = new Solution();
        System.out.println(solution.findCenter(edges));
    }
}