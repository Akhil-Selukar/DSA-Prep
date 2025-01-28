package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int target = 7;
//        int[] nums = {2,3,1,2,4,3};

        int target = 213;
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};

        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}