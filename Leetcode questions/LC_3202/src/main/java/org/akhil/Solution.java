package org.akhil;

public class Solution {
    // Solution 1 - Bruteforce (TLE)
    // O(N^2*K)/O(1)
//    public int maximumLength(int[] nums, int k) {
//        int maxCount = -1;
//        int n = nums.length;
//
//        for(int i=0; i<n-1; i++){
//            for(int rem=0; rem<k; rem++){
//                int prev = nums[i];
//                int count = 1;
//                for(int j=i+1; j<n; j++){
//                    if((prev+nums[j])%k == rem){
//                        count++;
//                        prev = nums[j];
//                    }
//                }
//                maxCount = Math.max(maxCount, count);
//            }
//        }
//        return maxCount;
//    }


    // Solution 2 -
    public int maximumLength(int[] nums, int k) {
        int maxCount = -1;
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            for(int rem=0; rem<k; rem++){
                int prev = nums[i];
                int count = 1;
                for(int j=i+1; j<n; j++){
                    if((prev+nums[j])%k == rem){
                        count++;
                        prev = nums[j];
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
