package org.akhil;

public class Solution {

    // O(N)/O(N)
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] forward = new int[n];
        int[] backward = new int[n];
        int result = Integer.MIN_VALUE;

        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                count++;
            } else {
                count = 0;
            }
            forward[i] = count;
        }

        count = 0;
        for(int i=n-1; i>=0; i--){
            if(nums[i] == 1){
                count++;
            } else {
                count = 0;
            }
            backward[i] = count;
        }

        for(int i=0; i<n; i++){
            if(forward[i] == 0){
                result = Math.max(result, (i == 0 ? 0 : forward[i-1]) + (i == n-1 ? 0 : backward[i+1]));
            }
        }

        return result == Integer.MIN_VALUE ? n-1 : result;
    }
}
