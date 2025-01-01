package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
//        int[] nums = {1,5,10,6};

        Solution solution = new Solution();
        System.out.println(solution.canPartition(nums));
    }
}