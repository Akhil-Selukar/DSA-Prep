package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int[] costs = {5,1,6,2};

        Solution solution = new Solution();
        System.out.println(solution.climbStairs(n, costs));
    }
}