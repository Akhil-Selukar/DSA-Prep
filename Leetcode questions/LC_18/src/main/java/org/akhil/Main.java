package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1,0,-1,0,-2,2};
//        int target = 0;
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;

        Solution solution = new Solution();
        System.out.println(solution.fourSum(nums, target));
    }
}