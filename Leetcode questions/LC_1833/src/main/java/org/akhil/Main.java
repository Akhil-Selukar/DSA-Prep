package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] costs = {1,6,3,1,2,5};
        int coins = 20;

        Solution solution = new Solution();
        System.out.println(solution.maxIceCream(costs, coins));
    }
}