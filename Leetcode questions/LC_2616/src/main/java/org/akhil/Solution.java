package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(N*logN)/O(1) in TC NlogN is dominant between O(logN + NlogN)
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);      // O(logN)

        // Binary search -> O(log(N) where N is the largest element in nums[].
        int start = 0;
        int end = nums[nums.length-1] - nums[0];
        int answer = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(isPairsPossible(mid, nums, p)){
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }

    // O(N)
    private boolean isPairsPossible(int mid, int[] nums, int p){
        int i=0;
        int count = 0;
        while(i<nums.length-1){
            if((nums[i+1]-nums[i]) <= mid){
                count++;
                i = i+2;
            } else {
                i++;
            }
            if(count >= p){
                return true;
            }
        }
        return count >= p;
    }
}

