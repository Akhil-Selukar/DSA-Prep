package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,1,4,3,2,2,4};
        int k = 2;

//        int[] nums = {1,1,1,1,1};
//        int k = 10;

        Solution solution = new Solution();
        System.out.println(solution.countGood(nums, k));
    }
}