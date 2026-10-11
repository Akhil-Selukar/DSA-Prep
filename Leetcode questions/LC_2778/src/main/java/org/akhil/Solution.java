package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int result = 0;

        for(int i=0; i<n; i++){
            if(isSpecial(i+1, n)){
                result = result + (nums[i] * nums[i]);
            }
        }
        return result;
    }

    private boolean isSpecial(int i, int n){
        return ((n%i) == 0);
    }
}
