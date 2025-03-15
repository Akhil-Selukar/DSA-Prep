package org.akhil;

public class Solution {

    // Time complexity - O(N*log(N))        -> the first for loop to calculate min and max will have O(N) (this will be non-dominant).
    // While loop is binary search hence O(LogN) and inside while for each iteration we are calling robbingPossible() which is O(N) method
    // hence the total Time Complexity is O(N)+O(N*Log(N)) and here O(N*Log(N)) is dominant hence we can say that overall time complexity is O(N*Log(N))
    // Space complexity - O(1)
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        while(min <= max){
            int mid = min + (max-min)/2;

            if(robbingPossible(mid, nums, k)){
                max = mid-1;
            } else {
                min = mid+1;
            }
        }

        return min;
    }

    private boolean robbingPossible(int capacity, int[] nums, int k){
        int housesRobbed = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] <= capacity){
                housesRobbed++;
                i++;
            }
        }

        if(housesRobbed >= k){
            return true;
        }
         return false;
    }
}
