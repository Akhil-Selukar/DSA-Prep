package org.akhil;

import java.util.Arrays;

public class Solution {

    // solution 1
//    public int singleNumber(int[] nums) {
//        int ans = 0;
//        for (int i = 0; i < 32; ++i) {
//            int sum = 0;
//            for (final int num : nums) {
//                sum += num >> i & 1;
//            }
//            sum %= 3;
//            ans = ans | sum << i;
//        }
//        return ans;
//    }

    // More intuitive and clean implementation of above approach
    public int singleNumber(int[] nums) {
        int result = 0;

        for(int i=0; i<=31; i++){
            int bitIndex = 1 << i;
            int countOfOne = 0;

            for(int num:nums){
                if((num & bitIndex) != 0){
                    countOfOne++;
                }
            }

            if(countOfOne % 3 == 1){
                result = (result | bitIndex);        // set bitIndex bit of result
            }
        }
        return result;
    }

    /*
     * Here in solution 1 the time complexity will be O(32*N) which is effectively O(N)
     * while in solution 2 the time complexity will be O(N*log(N)+3) which is O(N*log(N))
     * but to reach log(N) to 32 it will take array of size 2^32, for smaller sized array log(N) will be very very small
     * hence the time complexity will be O(<very small no>*N) which will be better than O(32*N) because in solution 1 no matter
     * how small or how big the array is, time complexity will always be O(32*N) (i.e. multiplying factor will always be 32).
     */

    // Solution 2
//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//
//        for(int i=1; i<nums.length; i+=3){
//            if(nums[i] != nums[i-1]){
//                return nums[i-1];
//            }
//        }
//
//        return nums[nums.length-1];
//    }
}
