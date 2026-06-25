package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        int target = 2;

        Solution solution = new Solution();
        System.out.println(solution.countMajoritySubarrays(nums, target));
    }
}