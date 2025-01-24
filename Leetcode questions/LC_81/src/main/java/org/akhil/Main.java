package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {2,5,6,0,0,1,2};
//        int target = 3;
        int[] nums = {1,0,1,1,1};
        int target = 0;

//        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
//        int target = 2;

        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
    }
}