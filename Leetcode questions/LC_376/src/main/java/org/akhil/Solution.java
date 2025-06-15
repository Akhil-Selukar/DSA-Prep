package org.akhil;

public class Solution {

    // O(N)/O(1)
    public int wiggleMaxLength(int[] nums) {
        // edge cases of nums having 1 or 2 elements
        if(nums.length <=1){
            return nums.length;
        }

        int violations = 0;
        boolean nextPositive = true;
        int start = 0;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]-nums[i] == 0){
                violations++;
                start = i+1;
            } else if (nums[i+1] - nums[i] > 0){
                nextPositive = false;
                start = i+1;
                break;
            } else {
                start = i+1;
                break;
            }
        }


        for(int i=start; i<nums.length-1; i++){
            if(nextPositive){
                if(nums[i+1]-nums[i] <= 0){
                    violations++;
                } else {
                    nextPositive = false;
                }
            } else {
                if(nums[i+1] - nums[i] >= 0){
                    violations++;
                } else {
                    nextPositive = true;
                }
            }
        }

        return nums.length - violations;
    }
}
