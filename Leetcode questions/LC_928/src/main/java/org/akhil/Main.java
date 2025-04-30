package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] graph = {{1,1,0},{1,1,0},{0,0,1}};
//        int[] initial = {0,1};

//        int[][] graph = {{1,1,0},{1,1,1},{0,1,1}};
//        int[] initial = {0,1};

//        int[][] graph = {{1,1,0,0},{1,1,1,0},{0,1,1,1},{0,0,1,1}};
//        int[] initial = {0,1};

        int[][] graph = {{1,1,1,0},{1,1,0,0},{1,0,1,0},{0,0,0,1}};
        int[] initial = {3,2};

        Solution solution = new Solution();
        System.out.println(solution.minMalwareSpread(graph, initial));
    }
}