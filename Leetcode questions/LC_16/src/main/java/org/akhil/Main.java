package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {-1,2,1,-4};
//        int[] nums = {0,0,0};
//        int target = 1;

//        int[] nums = {-1,2,1,-4};
//        int target = -1;

//        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
//        int target = -2;

//        int[] nums = {-4,2,2,3,3,3};
//        int target = 0;

        int[] nums = {2,5,6,7};
        int target = 16;

        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums, target));
    }
}