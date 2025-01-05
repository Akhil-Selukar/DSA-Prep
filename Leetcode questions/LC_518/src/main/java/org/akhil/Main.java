package org.akhil;

public class Main {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};

        Solution solution = new Solution();
        System.out.println(solution.change(amount, coins));
    }
}