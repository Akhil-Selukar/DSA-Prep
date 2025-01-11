package org.akhil;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3,2,6,5,0,3};

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(k, prices));
    }
}