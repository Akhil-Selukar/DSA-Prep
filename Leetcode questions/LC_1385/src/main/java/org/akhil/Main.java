package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;

        Solution solution = new Solution();
        System.out.println(solution.findTheDistanceValue(arr1, arr2, d));
    }
}