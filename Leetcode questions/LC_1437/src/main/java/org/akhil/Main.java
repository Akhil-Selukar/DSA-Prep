package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1,0,0,0,1,0,0,1};
        int[] nums = {1,0,0,1,0,1};
        int k = 2;
        Solution solution = new Solution();

        System.out.println(solution.kLengthApart(nums, k));
    }
}