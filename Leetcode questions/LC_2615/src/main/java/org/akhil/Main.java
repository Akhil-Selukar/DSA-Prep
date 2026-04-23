package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,1,1,2};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.distance(nums)));
    }
}