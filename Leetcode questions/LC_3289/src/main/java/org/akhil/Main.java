package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {7,1,5,4,3,4,6,0,9,5,8,2};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getSneakyNumbers(nums)));
    }
}