package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int k = 3;
//        int[] nums = {1,0,1,1};
//        int k = 1;
        int[] nums = {1,2,3,1,2,3};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
}