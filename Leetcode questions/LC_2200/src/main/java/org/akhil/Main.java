package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,4,9,1,3,9,5};
        int key = 9;
        int k = 1;

        Solution solution = new Solution();
        System.out.println(solution.findKDistantIndices(nums, key, k));
    }
}