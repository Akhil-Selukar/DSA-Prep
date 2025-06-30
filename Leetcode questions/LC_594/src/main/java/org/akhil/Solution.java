package org.akhil;

import java.util.Arrays;

public class Solution {

    // Here even though we need to find the subsequence but we are not actually dealing with the subsequence,
    // we just need to get the min and max from the subsequence. So no matter we write a subsequence as [1,2,3] or [2,1,3] or [2,3,1]
    // or [1,3,2] or [3,1,2] or anything but min and max of the subsequence still be 1 and 3 respectively.
    // So we can sort the array.

    // O(N*logN)/O(1)
    public int findLHS(int[] nums) {
        Arrays.sort(nums);      // O(N logN)
        int start = 0;
        int size = 0;

        for(int end = 0; end<nums.length; end++){       // O(N)
            while(nums[end] - nums[start] > 1){
                start++;
            }
            if(nums[end] - nums[start] == 1){
                size = Math.max(size, end-start+1);
            }
        }
        return size;
    }
}
