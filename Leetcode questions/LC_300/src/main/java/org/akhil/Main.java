package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};     // 4
//        int[] nums = {0,1,0,3,2,3};   // 4

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums));
    }
}