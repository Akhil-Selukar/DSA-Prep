package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {3,2,3,1,2,4,5,5,6};
//        int k = 4;
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, k));
    }
}