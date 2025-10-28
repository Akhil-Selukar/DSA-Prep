package org.akhil;

public class Solution {
//    // Solution 1 - Using two prefixSum arrays
//    // O(N)/O(N)
//    public int countValidSelections(int[] nums) {
//        int n = nums.length;
//        int result = 0;
//        int[] leftSum = new int[n];
//        int[] rightSum = new int[n];
//
//        leftSum[0] = nums[0];
//        rightSum[n-1] = nums[n-1];
//
//        for(int i=1; i<n; i++){
//            leftSum[i] = leftSum[i-1]+nums[i];
//            rightSum[n-i-1] = rightSum[n-i] + nums[n-i-1];
//        }
//
//        for(int i=0; i<n; i++){
//            if(nums[i] == 0){
//                int absDiff =Math.abs(leftSum[i]-rightSum[i]);
//                if(absDiff == 0){
//                    result = result + 2;
//                }
//                if(absDiff == 1){
//                    result = result + 1;
//                }
//            }
//        }
//        return result;
//    }

    // --------------------

    // Solution 2 - Without using prefix Sum arrays
    // O(N)/O(1)
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int result = 0;
        int leftSum = 0;
        int rightSum = 0;

        for(int i=0; i<n; i++){
            rightSum = rightSum + nums[i];
        }

        for(int i=0; i<n; i++){
            rightSum = rightSum - nums[i];
            leftSum = leftSum + nums[i];

            if(nums[i] == 0) {
                int absDiff = Math.abs(rightSum - leftSum);
                if (absDiff == 0) {
                    result = result + 2;
                }
                if (absDiff == 1) {
                    result = result + 1;
                }
            }
        }
        return result;
    }
}
