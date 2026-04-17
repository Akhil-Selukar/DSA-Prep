package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // O(N)/O(N)
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i])){
                minDistance = Math.min(minDistance, (i - map.get(nums[i])));
            }
            int mirrorVal = getReverse(nums[i]);
            map.put(mirrorVal, i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int getReverse(int num){
        int reverse = 0;
        while(num > 0){
            reverse = reverse * 10 + (num%10);
            num = num/10;
        }
        return reverse;
    }
}
