package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        Solution solution = new Solution();

        System.out.println(solution.longestConsecutive(nums));
    }
}