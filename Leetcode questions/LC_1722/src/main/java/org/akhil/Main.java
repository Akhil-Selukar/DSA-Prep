package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] source = {5,1,2,4,3};
        int[] target = {1,5,4,2,3};
        int[][] allowedSwaps = {{0,4},{4,2},{1,3},{1,4}};

        Solution solution = new Solution();
        System.out.println(solution.minimumHammingDistance(source, target, allowedSwaps));
    }
}