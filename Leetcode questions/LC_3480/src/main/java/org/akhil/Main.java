package org.akhil;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] conflictingPairs = {{1,2},{2,5},{3,5}};

        Solution solution = new Solution();

        System.out.println(solution.maxSubarrays(n, conflictingPairs));
    }
}