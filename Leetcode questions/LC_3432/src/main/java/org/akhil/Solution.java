package org.akhil;

public class Solution {
//    // O(N)/O(N)
//    public int countPartitions(int[] nums) {
//        int n = nums.length;
//        int[] prefixSum = new int[n];
//        prefixSum[0] = nums[0];
//
//        for(int i=1; i<n; i++){
//            prefixSum[i] = prefixSum[i-1]+nums[i];
//        }
//
//        int result = 0;
//        for(int i=0; i<n-1; i++){
//            int sum1 = prefixSum[i];
//            int sum2 = prefixSum[n-1] - sum1;
//
//            if((sum1 - sum2)%2 == 0){
//                result++;
//            }
//        }
//        return result;
//    }

    // -------------------
    // Solution 2 - constant memory solution
    // O(N)/O(N)
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int sum2 = 0;

        for(int i=0; i<n; i++){
            sum2 = sum2 + nums[i];
        }

        int result = 0;
        int sum1 = 0;
        for(int i=0; i<n-1; i++){
            sum1 = sum1 + nums[i];
            sum2 = sum2 - nums[i];
            if((sum1 - sum2)%2 == 0){
                result++;
            }
        }
        return result;
    }
}
