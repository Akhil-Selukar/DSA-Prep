package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,5,7,8,9,2,3,4,3,1);
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.hasIncreasingSubarrays(nums, k));
    }
}