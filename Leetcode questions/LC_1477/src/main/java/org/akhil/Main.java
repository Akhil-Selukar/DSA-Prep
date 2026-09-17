package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {7,3,4,7};
        int target = 7;

        Solution solution = new Solution();
        System.out.println(solution.minSumOfLengths(arr, target));
    }
}