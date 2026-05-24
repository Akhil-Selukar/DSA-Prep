package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr = {6,4,14,6,8,13,9,7,10,6,12};
        int d = 2;

        Solution solution = new Solution();
        System.out.println(solution.maxJumps(arr, d));
    }
}