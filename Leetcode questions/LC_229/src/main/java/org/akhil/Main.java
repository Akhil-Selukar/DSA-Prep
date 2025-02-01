package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
//        int[] nums = {3,2};
//        int[] nums = {3};
//        int[] nums = {3,2,3,1,3,4,5,6,5,3};
//        int[] nums = {2,2};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}