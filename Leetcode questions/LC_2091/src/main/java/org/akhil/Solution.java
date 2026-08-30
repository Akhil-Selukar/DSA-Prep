package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0;
        int maxIndex = 0;

        for(int i=0; i<n; i++){
            if(nums[i] < nums[minIndex]){
                minIndex = i;
            }
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }

        int option1 = Math.max(minIndex, maxIndex) + 1; // remove all values from front
        int option2 = Math.max(n-minIndex, n-maxIndex);     // remove all values from back
        int option3 = (Math.min(minIndex, maxIndex)+1) + (n-Math.max(minIndex, maxIndex)); // remove from both ends

        return Math.min(option1, Math.min(option2, option3));
    }
}
