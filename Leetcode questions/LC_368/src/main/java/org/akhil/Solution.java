package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] previousIndex = new int[n];
        int max = 0;
        int index = -1;

        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            count[i] = 1;
            previousIndex[i] = -1;
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j] == 0){
                    if(count[i]<count[j]+1){
                        count[i] = count[j]+1;
                        previousIndex[i] = j;
                    }
                }
            }
            if(count[i]>max){
                max = count[i];
                index = i;
            }
        }

        List<Integer> answer = new ArrayList();
        while(index != -1){
            answer.add(0, nums[index]);
            index = previousIndex[index];
        }
        return answer;
    }
}
