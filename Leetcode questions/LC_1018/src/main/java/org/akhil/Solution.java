package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Solution 1 - by storing actual number
    // O(N)/O(N)
    // Even though this solution looks perfect but based on the constraints given in question this solution will give wrong answer.
    // because every time we are doubling the stored number so after some time it is going to go even oob for long and we will get wrong answer.
//    public List<Boolean> prefixesDivBy5(int[] nums) {
//        long currNum = 0;
//        List<Boolean> result = new ArrayList<>();
//
//        for(int i=0; i<nums.length; i++){
//            currNum = (currNum * 2) + nums[i];
//
//            result.add((currNum % 5 == 0));
//        }
//        return result;
//    }

    // ----------------
    // Solution 2 - Storing remainder instead of actual number
    // O(N)/O(N)
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int currRem = 0;
        List<Boolean> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            currRem = ((currRem * 2) + nums[i]) % 5;

            result.add(currRem == 0);
        }
        return result;
    }
}
