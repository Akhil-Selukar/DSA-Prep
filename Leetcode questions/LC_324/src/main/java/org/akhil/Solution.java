package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - by sorting
    // O(NlogN)/O(N)
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Arrays.sort(nums);

        int smallerIndex = (n-1)/2;
        int greaterIndex = n-1;
        int index = 0;

        while(smallerIndex >= 0 || greaterIndex > (n-1)/2){
            if(index % 2 == 0){
                result[index] = nums[smallerIndex];
                smallerIndex--;
                index++;
            } else {
                result[index] = nums[greaterIndex];
                greaterIndex--;
                index++;
            }
        }

        for(int i=0; i<n; i++){
            nums[i] = result[i];
        }
    }
}
