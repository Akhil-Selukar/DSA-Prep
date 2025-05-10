package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;

//        int n = 3;
//        int[][] edges = {{0,1},{1,2},{0,2}};
//        double[] succProb = {0.5,0.5,0.3};
//        int start = 0;
//        int end = 2;

//        int n = 3;
//        int[][] edges = {{0,1}};
//        double[] succProb = {0.5};
//        int start = 0;
//        int end = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxProbability(n, edges, succProb, start, end));
    }
}