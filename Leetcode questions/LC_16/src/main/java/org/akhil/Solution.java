package org.akhil;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int answer = (int)1e9;

        Arrays.sort(nums);

        for(int i=0; i<n-2; i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];

                if(Math.abs(sum - target) < Math.abs(answer - target)){
                    answer = sum;
                } else if(sum < target){
                    j++;
                } else if(sum > target){
                    k--;
                } else {
                    return answer;
                }
            }
        }
        return answer;
    }
}
