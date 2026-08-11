package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // O(N)/O(N)
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> visited = new HashSet<>();

        for(int num:nums){
            visited.add(num);
        }
        int sum = nums[0];

        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]+1){
                sum = sum + nums[i];
            } else {
                break;  // important line to break and not go for next sequence 'In particular, the prefix consisting only of nums[0] is sequential.'
            }
        }

        while(visited.contains(sum)){
            sum++;
        }

        return sum;
    }
}
