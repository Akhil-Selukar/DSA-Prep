package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,5,6,7};
        int target = 9;

        Solution solution = new Solution();
        System.out.println(solution.numSubseq(nums, target));
    }
}