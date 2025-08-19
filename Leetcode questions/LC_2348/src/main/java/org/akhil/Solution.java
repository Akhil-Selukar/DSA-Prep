package org.akhil;

public class Solution {
    // O(N)/O(1)
    public long zeroFilledSubarray(int[] nums) {        // [0,0,0,2,0,0]
        long result = 0;
        int index = 0;

        while(index < nums.length){
            long continuousZeros = 0;
            if(nums[index] == 0) {
                while (index < nums.length && nums[index] == 0) {
                    continuousZeros++;
                    index++;
                }
                result = (long) (result + (continuousZeros * (continuousZeros+1)/2.0));  // (n*(n+1)/2)
            } else {
                index++;
            }
        }
        return result;
    }
}
