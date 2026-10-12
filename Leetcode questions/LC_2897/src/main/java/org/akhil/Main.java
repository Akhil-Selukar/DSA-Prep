package org.akhil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(4,5,4,7);
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.maxSum(nums, k));
    }
}