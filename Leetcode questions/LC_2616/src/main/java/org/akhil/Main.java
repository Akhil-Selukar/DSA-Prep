package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,1,3};
        int p = 2;

        Solution solution = new Solution();
        System.out.println(solution.minimizeMax(nums, p));
    }
}