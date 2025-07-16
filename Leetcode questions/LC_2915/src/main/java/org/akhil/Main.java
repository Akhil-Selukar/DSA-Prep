package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(1);
        nums.add(5);

        int target = 7;

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubsequence(nums, target));
    }
}