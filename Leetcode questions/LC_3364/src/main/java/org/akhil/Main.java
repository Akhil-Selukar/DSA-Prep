package org.akhil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int l = 2;
        int r = 4;

        Solution solution = new Solution();
        System.out.println(solution.minimumSumSubarray(nums, l, r));
    }
}