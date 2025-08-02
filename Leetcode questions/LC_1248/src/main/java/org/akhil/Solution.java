package org.akhil;

public class Solution {
    // Solution 1 - with 3 pointers
    // O(N)/O(1)
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        int left = 0;
        int mid = 0;
        int right = 0;
        int oddCount = 0;

        while(right < n){
            if(nums[right] % 2 == 1){
                oddCount++;
            }

            while(oddCount > k){
                if(nums[left] % 2 == 1){
                    oddCount--;
                }
                left++;
                mid = left;
            }

            if(oddCount == k){
                // this while loop is to handle cases like [2,2,1,1,2,1]
                // here because of 2,2 at the start the sub-arrays [2,2,1,1,2,1], [2,1,1,2,1] and [1,1,2,1] are valid and this is why we need 3rd pointer mid.
                while(nums[mid] % 2 == 0){
                    mid++;
                }
                result = result + (mid - left + 1);
            }

            right++;
        }
        return result;
    }
}
