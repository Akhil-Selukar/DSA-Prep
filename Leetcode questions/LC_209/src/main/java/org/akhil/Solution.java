package org.akhil;

public class Solution {

    // Solution 1 - Will give TLE
//    public int minSubArrayLen(int target, int[] nums) {
//
//        int minCount = Integer.MAX_VALUE;
//
//        for(int startIndex = 0; startIndex < nums.length; startIndex++){
//            int endIndex = startIndex;
//            int sum = 0;
//            while(endIndex < nums.length && sum < target){
//                sum = sum + nums[endIndex];
//                endIndex++;
//            }
//            if(sum >= target) {
//                minCount = Math.min(minCount, endIndex - startIndex);
//            }
//        }
//        return minCount == Integer.MAX_VALUE ? 0 : minCount;
//    }


    // Solution 2 - Sliding window
    public int minSubArrayLen(int target, int[] nums) {

        int minCount = Integer.MAX_VALUE;
        int startIndex = 0;
        int sum = 0;

        for(int endIndex = 0; endIndex<nums.length; endIndex++){
            sum = sum + nums[endIndex];

            while(sum >= target){
                minCount = Math.min(minCount, endIndex - startIndex + 1);

                sum = sum - nums[startIndex];
                startIndex++;
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}
