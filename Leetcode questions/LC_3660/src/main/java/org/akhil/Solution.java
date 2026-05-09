package org.akhil;

public class Solution {
    // Here we can track the maxValue seen to the left of curr value and min value present to the right of curr value
    // now using this if there is any min value present than curr value to the right then we can jump there and from there if there
    // is any max Value present to the left of that (jumped value) we can jump to the left max

    // O(N)/O(N)
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] maxToLeft = new int[n];
        int[] minToRight = new int[n];

        maxToLeft[0] = nums[0];
        minToRight[n-1] = nums[n-1];

        for(int i=1; i<n; i++){
            maxToLeft[i] = Math.max(maxToLeft[i-1], nums[i]);
            minToRight[n-1-i] = Math.min(minToRight[n-i], nums[n-i]);
        }

        int result[] = new int[n];

        result[n-1] = maxToLeft[n-1];


        for(int i=n-2; i>=0; i--) {
            if(maxToLeft[i] > minToRight[i+1])
                result[i] = result[i+1];
            else result[i] = maxToLeft[i];
        }

        return result;
    }
}
