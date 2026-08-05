package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int k = 0;
        int[][] invocations = {{1,2},{0,2},{0,1},{3,4}};

        Solution solution = new Solution();
        System.out.println(solution.remainingMethods(n, k, invocations));
    }
}