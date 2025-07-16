package org.akhil;

public class Solution {

    // Solution 1 - O(N)/O(1)
//    public int maximumLength(int[] nums) {
//        // if all elements are odd or all elements are event then that can be the longest subsequence
//        int oddCount = 0;
//        int evenCount = 0;
//
//        for(int num:nums){
//            if(num%2 == 0){
//                evenCount++;
//            } else {
//                oddCount++;
//            }
//        }
//
//        // alternate sum is odd or alternate sum is even can be the max
//        // if alternate sum is odd then all (nums[i-1]+nums[i])%2 will be 1
//        // if alternate sum is even then all (nums[i-1]+nums[i])%2 will be 0
//        // whichever is longest that will be required answer.
//        int alternateOddSum = 0;
//        int alternateEvenSum = 0;
//
//        for(int num:nums){
//            if(num%2 == 0){
//                alternateEvenSum = Math.max(alternateEvenSum, alternateOddSum+1);
//            } else {
//                alternateOddSum = Math.max(alternateOddSum, alternateEvenSum+1);
//            }
//        }
//
//        return Math.max(oddCount, Math.max(evenCount, Math.max(alternateEvenSum, alternateOddSum)));
//    }


    // --------------
    // Slightly improved approach
    // O(N)/O(1) -> reduced 1 loop
    public int maximumLength(int[] nums) {
        // if all elements are odd or all elements are event then that can be the longest subsequence
        int oddCount = 0;
        int evenCount = 0;
        int alternateOddSum = 0;
        int alternateEvenSum = 0;

        for(int num:nums){
            if(num%2 == 0){
                evenCount++;
                alternateEvenSum = Math.max(alternateEvenSum, alternateOddSum+1);
            } else {
                oddCount++;
                alternateOddSum = Math.max(alternateOddSum, alternateEvenSum+1);
            }
        }
        return Math.max(oddCount, Math.max(evenCount, Math.max(alternateEvenSum, alternateOddSum)));
    }
}
