package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] coins = {{0,1,-1},{1,-2,3},{2,-3,4}};

        Solution solution = new Solution();
        System.out.println(solution.maximumAmount(coins));
    }
}