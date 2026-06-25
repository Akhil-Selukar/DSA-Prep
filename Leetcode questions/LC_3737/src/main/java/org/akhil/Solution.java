package org.akhil;

public class Solution {
    // O(N^2)/O(1)
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int result = 0;

        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=i; j<n; j++){
                count = count + (nums[j] == target ? 1 : 0);

                if(count > (j-i+1)/2){
                    result++;
                }
            }
        }
        return result;
    }
}
