package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 1, 9, 7};
        int a = 7;
        int b = 2;
        int c = 3;

        Solution solution = new Solution();
        System.out.println(solution.countGoodTriplets(arr, a, b, c));
    }
}