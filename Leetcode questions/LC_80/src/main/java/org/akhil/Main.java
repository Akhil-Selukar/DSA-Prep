package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,1,2,3,3};
//        int[] nums = {1,1,1,2,2,};

        Solution solution = new Solution();

        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}