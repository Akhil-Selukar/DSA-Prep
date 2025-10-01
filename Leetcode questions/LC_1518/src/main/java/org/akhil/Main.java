package org.akhil;

public class Main {
    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;

        Solution solution = new Solution();
        System.out.println(solution.numWaterBottles(numBottles, numExchange));
    }
}