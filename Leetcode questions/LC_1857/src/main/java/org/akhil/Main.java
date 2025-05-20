package org.akhil;

public class Main {
    public static void main(String[] args) {
//        String colors = "abaca";
//        int[][] edges = {{0,1},{0,2},{2,3},{3,4}};

        String colors = "a";
        int[][] edges = {{0,0}};

        Solution solution = new Solution();
        System.out.println(solution.largestPathValue(colors, edges));
    }
}