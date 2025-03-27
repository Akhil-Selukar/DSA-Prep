package org.akhil;

import java.util.List;

public class Solution {
    public int minimumIndex(List<Integer> nums) {
        int domElement = nums.get(0);
        int freq = 1;
        int domFrequency = 0;
        int n = nums.size();

        // find dominant element
        for(int i=1; i<n; i++){
            if(nums.get(i) != domElement){
                freq--;
            } else {
                freq++;
            }

            if(freq == 0){
                domElement = nums.get(i);
                freq = 1;
            }
        }


        // find frequency of dominant element
        for(int i=0; i<n; i++){
            if(nums.get(i) == domElement){
                domFrequency++;
            }
        }

        // split the array and check
        int leftCount = 0;
        int rightCount = domFrequency;
        for(int i=0; i<n; i++){
            if(domElement == nums.get(i)){
                leftCount++;
                rightCount--;
            }
            if(leftCount > (i+1)/2 && rightCount > (n-i-1)/2){
                return i;
            }
        }

        return -1;
    }
}
