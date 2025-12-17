package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        int[] present = {1,2};
        int[] future = {4,3};
        int[][] hierarchy = {{1,2}};
        int budget = 3;

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(n, present, future, hierarchy, budget));
    }
}