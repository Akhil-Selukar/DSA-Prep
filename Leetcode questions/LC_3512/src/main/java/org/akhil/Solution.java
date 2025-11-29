package org.akhil;

public class Solution {
    // Solution 1 - Suth streams
    // O(N)/O(1)
    // public int minOperations(int[] nums, int k) {
    //     int sum = Arrays.stream(nums).sum();

    //     return sum%k;
    // }

    //---------------------
    // Same concept without streams
    // O(N)/O(1)
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int num:nums){
            sum = sum+num;
        }

        return sum%k;
    }
}
