package org.akhil;

public class Solution {
    // Bruteforce
    // O(Nlog(N))/O(1)
    // public int findMin(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[0];
    // }

    // --------------------
    // Solution 2: bruteforce
    // O(N)/O(1)    faster(100%)
    // public int findMin(int[] nums) {
    //     int min = Integer.MAX_VALUE;

    //     for(int num:nums){
    //         min = Math.min(min, num);
    //     }
    //     return min;
    // }

    // --------------------
    // Solution 3 - Binary search
    // O(logN)/O(1)
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int result = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end-start)/2;
            result = Math.min(result, nums[mid]);

            // skip the duplicates
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }

            if(nums[start] <= nums[mid]){
                result = Math.min(result, nums[start]);
                start = mid+1;
            } else {
                result = Math.min(result, nums[end]);
                end = mid-1;
            }
        }
        return result;
    }
}
