package org.akhil;

import java.util.Arrays;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        int[] lis = new int[n];         // this is where we are using DP.
        int[] count = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);

        int maxLength = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    if(lis[i] < lis[j]+1){
                        lis[i] = lis[j]+1;
                        count[i] = count[j];
                    } else if(lis[j]+1 == lis[i]){
                        count[i] = count[i]+count[j];
                    }
                }
            }
            maxLength = Math.max(lis[i], maxLength);
        }

        int maxCount = 0;
        for(int i=0; i<n; i++){
            if(maxLength == lis[i]){
                maxCount = maxCount+count[i];
            }
        }
        return maxCount;
    }
}
