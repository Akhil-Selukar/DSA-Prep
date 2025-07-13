package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int countHillValley(int[] nums) {
        int length = nums.length;

        if(length <= 2){
            return 0;
        }

        int prev = 0;
        int curr = 1;
        int next = 2;
        int count = 0;

        while(next < length){
            while(next < length && nums[prev] == nums[curr]){
                prev++;
                curr++;
                next++;
            }

            while(next < length && nums[curr] == nums[next]){
                next++;
                curr++;
            }

            if(next < length && ((nums[prev] < nums[curr] && nums[curr] > nums[next]) || (nums[prev] > nums[curr] && nums[curr] < nums[next]))){
                count++;
            }

            prev = curr;
            curr = next;
            next++;
        }

        return count;
    }
}
