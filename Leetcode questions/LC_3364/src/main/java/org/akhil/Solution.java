package org.akhil;

import java.util.List;

public class Solution {
    // O(N^2)/O(1)
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int result = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<Math.min(i+l-1, n); j++){
                sum = sum + nums.get(j);
            }

            for(int j=i+l-1; j<n; j++){
                if(j-i+1 > r){
                    break;
                }
                sum = sum + nums.get(j);
                if(sum > 0){
                    result = Math.min(result, sum);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
