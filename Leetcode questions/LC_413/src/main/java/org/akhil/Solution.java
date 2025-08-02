package org.akhil;

public class Solution {

    /**
     * Here the most important this is the formula
     * -> number of subarrays of size 'k' in an array of length 'len' are
     *  (len * (len-1))/k-1
     * */

    // Solution 1
    // O(N)/O(N)
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3){
            return 0;
        }

        // create diff array which store diff between two consecutive numbers in nums.
        int[] diff = new int[n-1];
        for(int i=1; i<n; i++){
            diff[i-1] = nums[i]-nums[i-1];
        }

        // count the subarrays of same diff
        int start = 0;
        int count = 0;

        while(start < diff.length){
            int end = start;

            // finding the segment in diff where difference value is same.
            while(end+1 < diff.length && diff[end+1] == diff[start]){
                end++;
            }

            int lengthOfSegment = end-start+1;

            if(lengthOfSegment > 2){        // here we need to allow length of segment = 2 because this length is of diff array and diff array with 2 elements means actual nums array with 3 elements (then only we will get 2 diff values)
                count = count + (lengthOfSegment * (lengthOfSegment - 1))/2;
            }

            // switch to next segment
            start = end+1;
        }
        return count;
    }
}
