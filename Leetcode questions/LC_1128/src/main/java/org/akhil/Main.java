package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        int[][] dominoes = {{1,2},{1,2},{1,1},{1,2},{2,2}};

        Solution solution = new Solution();
        System.out.println(solution.numEquivDominoPairs(dominoes));
    }
}