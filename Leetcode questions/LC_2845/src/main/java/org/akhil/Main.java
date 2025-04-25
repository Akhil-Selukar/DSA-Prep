package org.akhil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3,2,4);
        int modulo = 2, k = 1;

        Solution solution = new Solution();
        System.out.println(solution.countInterestingSubarrays(nums, modulo, k));
    }
}