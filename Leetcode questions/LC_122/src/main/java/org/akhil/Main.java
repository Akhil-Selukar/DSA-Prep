package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.maxProfit_anotherWay(prices));
    }
}