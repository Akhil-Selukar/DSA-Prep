package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,2,4,5,6};
//        int[] nums = {5,2,1,2,5,2,1,2,5};

        Solution solution = new Solution();
        System.out.println(solution.maximumUniqueSubarray(nums));
    }
}