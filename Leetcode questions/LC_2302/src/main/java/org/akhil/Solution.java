package org.akhil;

public class Solution {

    // Solution 1 - bruteforce (O(N^2)/O(1)) will give TLE
//    public long countSubarrays(int[] nums, long k) {
//        long count = 0;
//        for (int right = 0; right < nums.length; right++) {
//            long sum = 0;
//            for (int left = right; left < nums.length; left++) {
//                sum += nums[left];
//                if (sum * (left - right + 1) < k) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }


    // Solution 2 - 2 pointers sliding window (O(N)/O(1))
    public long countSubarrays(int[] nums, long k) {
        int p1 = 0;
        int p2 = 0;
        long count = 0;
        long sum = 0;

        while(p2 < nums.length){
            sum = sum + nums[p2];
            while(sum * (p2-p1+1) >= k){
                sum = sum - nums[p1];
                p1++;
            }
            count = count + (p2-p1+1);
            p2++;
        }
        return count;
    }
}
