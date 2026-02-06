package org.example;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,2,6,4,2};
        int k = 3;
        int dist = 3;

        Solution solution = new Solution();
        System.out.println(solution.minimumCost(nums, k, dist));
    }
}