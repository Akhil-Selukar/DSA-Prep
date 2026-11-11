package org.akhil;

public class Main {
    public static void main(String[] args) {
        int cost1 = 5;
        int cost2 = 4;
        int costBoth = 15;
        int need1 = 2;
        int need2 = 3;

        Solution solution = new Solution();
        System.out.println(solution.minimumCost(cost1, cost2, costBoth, need1, need2));
    }
}