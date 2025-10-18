package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4};
        int k = 2;

//        int[] nums = {7,8,10,10,7,6,7};
//        int k = 1;

        Solution solution = new Solution();
        System.out.println(solution.maxDistinctElements(nums, k));
    }
}