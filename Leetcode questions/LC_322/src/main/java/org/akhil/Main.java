package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] coins = {1,2,5};
//        int amount = 11;

//        int[] coins = {2,5,10,1};
//        int amount = 27;

        int[] coins = {186,419,83,408};
        int amount = 6249;

        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, amount));
    }
}