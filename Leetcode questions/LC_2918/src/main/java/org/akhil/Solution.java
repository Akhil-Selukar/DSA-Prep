package org.akhil;

public class Solution {

    // O(N1+N2)/O(1)
    public long minSum(int[] nums1, int[] nums2) {
        long[] numSum1 = operate(nums1);        // O(N1)
        long[] numSum2 = operate(nums2);        // O(N2)
        long num1Zero = numSum1[0];
        long num1Sum = numSum1[1];
        long num2Zero = numSum2[0];
        long num2Sum = numSum2[1];

        long minPossibleOfNums1 = num1Sum + num1Zero;
        long minPossibleOfNums2 = num2Sum + num2Zero;

        // case 1 - both arrays does not have any 0
        if(num1Zero == 0 && num2Zero == 0){
            return (num1Sum == num2Sum) ? num1Sum : -1;
        }

        // case 2 - if there are no zeros in nums1 but some zeros in nums2
        if(num1Zero == 0){
            return (num2Sum + num2Zero) <= num1Sum ? num1Sum : -1;
        }

        // case 3 - if there are no zeros in nums2 but some zeros in nums1
        if(num2Zero == 0){
            return (num1Sum + num1Zero) <= num2Sum ? num2Sum : -1;
        }

        return Math.max(minPossibleOfNums1, minPossibleOfNums2);
    }

    private long[] operate(int[] nums) {        // O(N)/ O(1)
        long count = 0;
        long sum = 0;
        for(int num:nums){
            if(num == 0){
                count++;
            }
            sum = sum+num;
        }
        return new long[]{count, sum};
    }
}
