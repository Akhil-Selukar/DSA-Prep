package org.akhil;

public class Solution {
    // O(N)/O(N)
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] greaterAtLeft = new int[n];
        int[] smallerAtRight = new int[n];

        for(int i=0; i<n; i++){
            greaterAtLeft[i] = Math.max(i==0?0:greaterAtLeft[i-1], nums[i]);
            smallerAtRight[n-1-i] = Math.min(i==0?Integer.MAX_VALUE:smallerAtRight[n-i], nums[n-1-i]);
        }

        for(int i=0; i<n; i++){
            if((greaterAtLeft[i] - smallerAtRight[i]) <= k){
                return i;
            }
        }
        return -1;
    }
}
