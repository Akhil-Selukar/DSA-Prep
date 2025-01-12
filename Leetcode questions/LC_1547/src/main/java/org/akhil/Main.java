package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 7;
        int[] cuts = {1,3,4,5};

        Solution solution = new Solution();
        System.out.println(solution.minCost(n, cuts));
    }
}