package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,6,1,2,5};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.partitionArray(nums, k));
    }
}