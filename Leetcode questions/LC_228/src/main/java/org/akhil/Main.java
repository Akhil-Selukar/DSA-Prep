package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {0,1,2,4,5,7};
//        int[] nums = {0,2,3,4,6,8,9};
//        int[] nums = {};
//        int[] nums = {0};
        int[] nums = {0,1,2,3,4,6,7,8,9,15};

        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(nums));
    }
}