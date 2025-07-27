package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,3,1};
//        int[] nums = {1,3,2,3,1};

        Solution solution = new Solution();
        solution.wiggleSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}