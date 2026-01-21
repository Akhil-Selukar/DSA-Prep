package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> nums = new ArrayList<>(Arrays.asList(2,3,5,7));

        System.out.println(Arrays.toString(solution.minBitwiseArray(nums)));
    }
}