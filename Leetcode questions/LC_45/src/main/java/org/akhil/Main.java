package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {2,3,0,1,4};
//        int[] nums = {2,3,1,1,4,1,1,2};
//        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};

        Solution solution = new Solution();
        System.out.println(solution.jump(nums));
    }
}