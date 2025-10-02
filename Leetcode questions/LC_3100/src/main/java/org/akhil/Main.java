package org.akhil;

public class Main {
    public static void main(String[] args) {
        int numBottles = 13;
        int numExchange = 6;

        Solution solution = new Solution();
        System.out.println(solution.maxBottlesDrunk(numBottles, numExchange));
    }
}