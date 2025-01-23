package org.akhil;

public class Solution {
    // Solution 1 - O(N)/O(1)
//    public boolean canJump(int[] nums) {
//        int n = nums.length;
//        if(n<=1){
//            return true;
//        }
//
//        boolean possible = false;
//        int steps = 1;
//        for(int i=n-2; i>=0; i--){
//            if(nums[i] >= steps && steps != 0){
//                steps = 0;
//                possible = true;
//            } else {
//                possible = false;
//            }
//            steps++;
//        }
//        return possible;
//    }

    // Solution 2 - O(N)/O(1) (little simplified and less complex, but actually time wise above one is better.)
    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        for(int i=0; i<nums.length; i++){
            if(maxReachable >= i) {
//                int maxReachableFromCurrent = nums[i] + i;
                maxReachable = Math.max(maxReachable, nums[i] + i);
            } else {
                return false;
            }
        }
        return true;
    }
}
