package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int n = 4;
//        int[][] dislikes = {{1,2},{1,3},{2,4}};

        int n = 3;
        int[][] dislikes = {{1,2},{1,3},{2,3}};

        Solution solution = new Solution();
        System.out.println(solution.possibleBipartition(n, dislikes));
    }
}