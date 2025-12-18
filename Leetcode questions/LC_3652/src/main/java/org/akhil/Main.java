package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] prices = {4,2,8};
//        int[] strategy = {-1,0,1};
//        int k = 2;

//        int[] prices = {5,4,3};
//        int[] strategy = {1,1,0};
//        int k = 2;

        int[] prices = {5,8};
        int[] strategy = {-1,-1};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices, strategy, k));
    }
}