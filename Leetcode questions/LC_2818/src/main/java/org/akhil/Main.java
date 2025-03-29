package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {8,3,9,3,8};
        List<Integer> numbers = Arrays.asList(nums);
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.maximumScore(numbers, k));
    }
}