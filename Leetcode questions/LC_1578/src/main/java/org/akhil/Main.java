package org.akhil;

public class Main {
    public static void main(String[] args) {
        String colors = "aabaa";
        int[] neededTime = {1,2,3,4,1};

        Solution solution = new Solution();
        System.out.println(solution.minCost(colors, neededTime));
    }
}