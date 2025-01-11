package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices, fee));
    }
}