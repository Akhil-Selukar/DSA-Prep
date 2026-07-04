package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};

        Solution solution = new Solution();
        System.out.println(solution.minScore(n, roads));

    }
}