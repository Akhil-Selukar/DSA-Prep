package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,2,3,0,3,1,2};
        int start = 5;

        Solution solution = new Solution();
        System.out.println(solution.canReach(nums, start));
    }
}