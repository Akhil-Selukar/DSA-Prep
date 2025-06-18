package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(NlogN)/O(N)
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int [][] ans = new int[n/3][3];

        Arrays.sort(nums);

        for(int i=0; i<n; i+=3){
            int rowIndex = i/3;
            if(nums[i+2] - nums[i] > k){
                return new int[][]{};
            }
            int[] subArray = new int[3];
            subArray[0] = nums[i];
            subArray[1] = nums[i+1];
            subArray[2] = nums[i+2];

            ans[rowIndex] = subArray;
        }
        return ans;
    }
}
