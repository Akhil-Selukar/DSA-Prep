package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.maxSumAfterPartitioning(arr, k));
    }
}