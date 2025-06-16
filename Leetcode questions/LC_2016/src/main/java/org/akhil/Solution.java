package org.akhil;

public class Solution {

    // Solution 1 - By tracking previousMin/leftMin
    // O(N)/O(N)
//    public int maximumDifference(int[] nums) {
//        int[] leftLowest = new int[nums.length];
//        int result = -1;
//        leftLowest[0] = nums[0];
//        int lowest = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            leftLowest[i] = Math.min(lowest, nums[i]);
//            result = Math.max(result, nums[i] - lowest);
//            lowest = Math.min(lowest, nums[i]);
//        }
//
//        return result == 0 ? -1 : result;
//    }

    // Solution 2 -> as we are not using each and every left min so we dont have to store them we can simply keel only the min value.
    // O(N)/O(1)
    public int maximumDifference(int[] nums) {
        int result = -1;
        int lowest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(lowest < nums[i]){
                result = Math.max(result, nums[i] - lowest);
            } else {
                lowest = nums[i];
            }
        }
        return result;
    }
}
