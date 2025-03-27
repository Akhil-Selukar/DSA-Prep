package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Integer[] nums = {2,1,3,1,1,1,7,1,2,1};
//        Integer[] nums = {3,3,3,3,7,2,2};
        Integer[] nums = {1,1,1,2};

        Solution solution = new Solution();
        System.out.println(solution.minimumIndex(Arrays.asList(nums)));
    }
}