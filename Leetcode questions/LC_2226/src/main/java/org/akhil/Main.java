package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] candies = {5,8,6};
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.maximumCandies(candies, k));
    }
}