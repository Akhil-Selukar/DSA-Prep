package org.akhil;

public class Solution {

    // Solution 1 - Normal recursion
//    public int jump(int[] nums) {
//        return helper(nums, 0);
//    }
//
//    private int helper(int[] nums, int currentIndex) {
//        if (currentIndex >= nums.length - 1) {
//            return 0;
//        }
//
//        int minJumps = Integer.MAX_VALUE;
//
//        // Explore all possible jumps from the current index
//        for (int jumpSize = 1; jumpSize <= nums[currentIndex]; jumpSize++) {
//            int nextIndex = currentIndex + jumpSize;
//            if (nextIndex < nums.length) {
//                int subJumps = helper(nums, nextIndex);
//                // Only consider paths that can potentially reach the end
//                if (subJumps != Integer.MAX_VALUE) {
//                    minJumps = Math.min(minJumps, 1 + subJumps);
//                }
//            }
//        }
//
//        return minJumps;
//    }

    // Solution 2 - Optimized (Without recursion, using jump window) (In below code jumpWindowStart is kept for understanding purpose, we can remove this.
    public int jump(int[] nums) {
        int n = nums.length;
        int jumpWindowStart = 0;
        int jumpWindowEnd = 0;
        int currentEnd = jumpWindowEnd;
        int jumps = 0;

        for(int i=0; i<n-1; i++){
            jumpWindowStart = jumpWindowEnd + 1;
            jumpWindowEnd = Math.max(jumpWindowEnd, (i+nums[i]));
            if(i == currentEnd){
                jumps++;
                currentEnd = jumpWindowEnd;
            }
        }
        return jumps;
    }
}
