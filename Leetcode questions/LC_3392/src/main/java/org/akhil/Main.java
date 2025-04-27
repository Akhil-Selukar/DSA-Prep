package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1,2,1,4,1};
//        int[] nums = {1,1,1};
        int[] nums = {-1,-4,-1,4};

        Solution solution = new Solution();
        System.out.println(solution.countSubarrays(nums));
    }
}