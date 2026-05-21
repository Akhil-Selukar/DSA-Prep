package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1,10,100};
        int[] arr2 = {1000};

        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(arr1, arr2));
    }
}