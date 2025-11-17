package org.akhil;

public class Solution {

    // O(N)/O(1)
    public boolean kLengthApart(int[] nums, int k) {
        int lastOneIndex = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                if(lastOneIndex >= 0){
                    if((i - lastOneIndex - 1) < k){
                        return false;
                    } else {
                        lastOneIndex = i;
                    }
                } else {
                    lastOneIndex = i;
                }
            }
        }
        return true;
    }
}
