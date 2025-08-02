package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;

//        int[] nums = {2,2,2,1,2,2,1,2,2,2};
//        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.numberOfSubarrays(nums, k));
    }
}