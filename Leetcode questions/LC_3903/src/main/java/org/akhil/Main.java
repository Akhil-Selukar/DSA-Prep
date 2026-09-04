package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5,0,1,4};
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.firstStableIndex(nums, k));
    }
}