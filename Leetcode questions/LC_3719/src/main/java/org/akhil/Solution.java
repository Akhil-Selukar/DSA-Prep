package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // O(N^2)/O(N)
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int result = 0;

        Set<Integer> odd = new HashSet<>();
        Set<Integer> even = new HashSet<>();

        for(int i=0; i<n; i++){
            odd.clear();
            even.clear();

            for(int j=i; j<n; j++){
                int currVal = nums[j];

                if(currVal%2 == 0){
                    even.add(currVal);
                } else {
                    odd.add(currVal);
                }

                if(even.size() == odd.size()){
                    result = Math.max(result, j-i+1);
                }
            }
        }

        return result;
    }
}
