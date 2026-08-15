package org.akhil;

public class Solution {
    // Here the important thing to observe is if we are getting XOR of a,b, and c as 0 then that means XOR of a and b will be c
    // XOR of b and c will be a and XOR of a and c will be b. Because unless we are getting same numbers XOR is not going to be 0.
    // So if overall we are getting 0 as XOR then we can simply omit 1 value in array to prevent 0 XOR and the rest subarray will
    // be the answer. If overall XOR is not zero then we can simply take entire array and if all elements in array is 0 then we
    // can not take any value.

    // O(N)/O(1)
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int overallXor = 0;
        boolean allZero = true;

        for(int num:nums){
            overallXor = overallXor ^ num;
            if(num != 0){
                allZero = false;
            }
        }

        if(allZero){
            return 0;
        }

        return overallXor == 0 ? n-1 : n;
    }
}
