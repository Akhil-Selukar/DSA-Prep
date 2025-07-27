package org.akhil;

public class Solution {
    // O(N)/O(1)
    public boolean increasingTriplet(int[] nums) {

        if(nums.length < 3){
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num:nums){
            if(num <= first){       // found new first
                first = num;
            } else if(num <= second){       // found new second (i.e. current num is greater than first but smaller than old second hence this will be out new second)
                second = num;
            } else {
                return true;    // num is greater than both first and second hence this is our third number and as 3rd num is found hence retuen true.
            }
        }

        return false;
    }
}
